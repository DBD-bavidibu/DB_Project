# 디비디바비디부

## 🛠 How to Run

---

1. Connect Database
    In [application.properties],
    
    1. Input your Database url, username,and password
    
    
    In [InitDB.java],
    
    1. Input you Dataabase url, username, password

2. Init Database

    In [Application.java],

    1. Drop Tables if not exists (optional 또는 쉘, admin으로 해도됩니다.)
    2. Create Tables if not exists (optional 또는 쉘, admin으로 해도됩니다.)
    3. Insert Cities 
    4. Insert Stores

3. Connect Web 
    1. Run Application.java
    2. Connect "localhost:8080"