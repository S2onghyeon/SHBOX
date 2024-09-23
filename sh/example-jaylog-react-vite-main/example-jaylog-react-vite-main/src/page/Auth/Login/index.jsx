import JaylogImg from "/src/asset/image/jaylog.png";
import {useEffect, useRef} from "react";
import {Button, Card, Col, Form, InputGroup, Row} from "react-bootstrap";
import {Link, useNavigate} from "react-router-dom";
import {useAuthStore} from "/src/store/provider/StoreProvider.jsx";
import usePendingFunction from "/src/use/usePendingFunction.jsx";
import UserInfoLayout from "/src/page/_component/layout/UserInfoLayout/index.jsx";
import Custom from "/src/util/Custom.js";
import UtilFunctions from "/src/util/UtilFunctions.js";

export default function AuthJoinLogin() {
    const refs = useRef({
        idElement: null,
        pwElement: null,
        rememberMeElement: null,
    });

    const authStore = useAuthStore();
    const navigate = useNavigate();

    const validateFields = () => {
        if (refs.current.idElement.value === "") {
            alert("아이디를 입력해주세요.");
            refs.current.idElement.focus();
            return false;
        }

        if (refs.current.pwElement.value === "") {
            alert("비밀번호를 입력해주세요.");
            refs.current.pwElement.focus();
            return false;
        }

        return true;
    };

    const [requestLogin, isPending] = usePendingFunction(async () => {
        if (!validateFields()) {
            return;
        }

        const {idElement, pwElement, rememberMeElement} = refs.current;

        const reqDto = {
            user: {
                username: idElement.value,
                password: pwElement.value,
            }
        };

        await fetch(`${Custom.baseUrl}/v1/auth/login`, {
            method: `post`,
            body: JSON.stringify(reqDto),
            headers: {
                "Content-Type": "application/json",
            }
        }).then((response) => {
            if (response?.status === 200) {
                if (rememberMeElement.checked) {
                    localStorage.setItem("rememberId", JSON.stringify(idElement.value));
                } else {
                    localStorage.removeItem("rememberId");
                }
                response.json()
                    .then((dto) => {
                        localStorage.setItem("accessJwt", dto.data.accessJwt);
                        localStorage.setItem("refreshJwt", dto.data.refreshJwt);
                        authStore.setLoginUser(() => UtilFunctions.getUserByAccessJwt());
                        navigate("/");
                    });
            } else {
                UtilFunctions.handleNotOkResponse(response);
            }
        });
    });

    const enterKeyLogin = (event) => {
        if (event.keyCode === 13) {
            requestLogin();
        }
    };

    const setLoginPage = () => {
        refs.current.idElement.focus();
        const rememberId = JSON.parse(localStorage.getItem("rememberId"));
        if (rememberId !== null) {
            refs.current.idElement.value = rememberId;
            refs.current.rememberMeElement.checked = true;
        }
    };

    useEffect(() => {
        setLoginPage();
    }, []);

    useEffect(() => {
        authStore.setLoginUser(null);
    }, [authStore]);

    return (
        <UserInfoLayout isNavbar={true}>
            <Card className="shadow-2-strong" style={{borderRadius: "1rem"}}>
                <Card.Body className="p-5 text-center">
                    <h3 className="mb-3">
                        <img src={JaylogImg} style={{height: "100px"}} alt="jaylog"></img>
                    </h3>
                    <InputGroup className="mb-3">
                        <InputGroup.Text id="idAddOn">&nbsp;아이디 &nbsp;</InputGroup.Text>
                        <Form.Control
                            ref={(el) => (refs.current.idElement = el)}
                            type="text"
                            aria-describedby="idAddOn"
                        />
                    </InputGroup>
                    <Row>
                        <Col>
                            <InputGroup className="mb-3">
                                <InputGroup.Text id="idAddOn">비밀번호</InputGroup.Text>
                                <Form.Control
                                    ref={(el) => (refs.current.pwElement = el)}
                                    type="password"
                                    onKeyUp={enterKeyLogin}
                                />
                            </InputGroup>
                        </Col>
                    </Row>
                    <Form.Group className="d-flex justify-content-start mb-4">
                        <Form.Check
                            type="checkbox"
                            ref={(el) => (refs.current.rememberMeElement = el)}
                            label="아이디 기억하기"
                        ></Form.Check>
                    </Form.Group>
                    <Button
                        className="btn-primary"
                        type="button"
                        style={{width: "100%"}}
                        onClick={requestLogin}
                        disabled={isPending}
                    >
                        로그인
                    </Button>
                    <hr className="my-4"/>
                    <Link to="/auth/join">아이디가 없으신가요? 회원가입</Link>
                </Card.Body>
            </Card>
        </UserInfoLayout>
    );
}
