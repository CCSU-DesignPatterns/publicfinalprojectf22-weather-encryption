# Encription API

This API can be used to encrypt a string using the encryption algorithm of your choice from the implemented list below.

Encryption Algorithms to choose from

- AES (Default)
- RSA (Coming soon)
- DES (Coming soon)

You can use this by first creating an instance of the class with

```
Encrypt enc = Encrypt.getInstance();
```

then you can encrypt and decrypt

```
String source = "Here is some string";
System.out.println(source);
String password = "p@ssW0rd";

String encryptString = enc.encrypt(source, password);
System.out.println(encryptString);

String decrypString = enc.decrypt(encryptString, password);
System.out.println(decrypString);
```
