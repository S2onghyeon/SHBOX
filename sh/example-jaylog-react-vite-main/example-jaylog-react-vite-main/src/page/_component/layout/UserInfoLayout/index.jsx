import {Col, Container, Row} from "react-bootstrap";
import DefaultNavbar from "/src/page/_component/common/DefaultNavbar/index.jsx";
import PropTypes from "prop-types";

UserInfoLayout.propTypes = {
    children: PropTypes.node.isRequired,
}

export default function UserInfoLayout({children}) {
    return (
        <section style={{backgroundColor: "#508bfc", minHeight: "100vh"}}>
            <DefaultNavbar/>
            <Container className="py-5 h-100">
                <Row className="d-flex justify-content-center align-items-center h-100">
                    <Col className="col-12 col-md-8 col-lg-6 col-xl-5">{children}</Col>
                </Row>
            </Container>
        </section>
    );
}

