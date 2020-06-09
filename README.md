# 디비디바비디부

## 🛠 How to Run

---

1. Connect Database
    In [application.properties],
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/98a02391-9d25-44ca-9a7e-68255658b44e/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/98a02391-9d25-44ca-9a7e-68255658b44e/Untitled.png)
    
    1. Input your Database url, username,and password
    
    
    In [InitDB.java],
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2a6b85e0-29ff-4879-a4ad-1a6434d6dcce/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2a6b85e0-29ff-4879-a4ad-1a6434d6dcce/Untitled.png)
    1. Input you Dataabase url, username, password

2. Init Database

    In [Application.java],

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4553378f-ca3c-46a8-baf2-9038ef2ff8ac/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4553378f-ca3c-46a8-baf2-9038ef2ff8ac/Untitled.png)

     

    1. Drop Tables if not exists (optional 또는 쉘, admin으로 해도됩니다.)
    2. Create Tables if not exists (optional 또는 쉘, admin으로 해도됩니다.)
    3. Insert Cities 
    4. Insert Stores

3. Connect Web 
    1. Run Application.java
    2. Connect "localhost:8080"

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ecb87054-21cb-4d0e-9968-12b29f90cc48/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ecb87054-21cb-4d0e-9968-12b29f90cc48/Untitled.png)