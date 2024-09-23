import tensorflow as tf

@tf.function
def add(a,b):
    return a + b 

x = tf.constant(3)
y = tf.constant(4)

result = add(x, y)
print(result)