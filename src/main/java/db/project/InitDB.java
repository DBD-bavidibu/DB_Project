package db.project;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.util.Date;

public class InitDB {

    //본인의 DB 정보 넣으시면 됩니다.
    private String DBURL = "jdbc:postgresql://localhost:5432/DB_Project";
    private String DBUser = "postgres";
    private String DBPassword = "0000";

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    String StoreURL = "https://openapi.gg.go.kr/RegionMnyFacltStus";
    private String apiKey = "abf21a2d4dd741f39b8d6dabf6522769";


    InitDB() throws SQLException {
        connection = DriverManager.getConnection(DBURL, DBUser, DBPassword);
        statement = connection.createStatement();
    }

    /******************************
     * drop table : 테이블 초기화시켜야할 때
     *****************************/
    public void dropTable() throws SQLException {
        String dropTable = "DROP TABLE IF EXISTS Stores;";
        statement.executeUpdate(dropTable);
        dropTable="DROP TABLE IF EXISTS Users;";
        statement.executeUpdate(dropTable);
        dropTable="DROP TABLE IF EXISTS Cities;";
        statement.executeUpdate(dropTable);
        dropTable="DROP TABLE IF EXISTS Likes;";
        statement.executeUpdate(dropTable);
    }

    /*****************************************

     create table : 테이블 생성
     **************************************/
    public void createTables() throws SQLException {
        String createTable="create table Cities(" +
                "    city_code integer primary key," +
                "    city_name varchar(50) not null," +
                "    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        statement.executeUpdate(createTable);
        createTable = "create table Stores(" +
                "    store_id serial primary key," +
                "    city_code integer not null," +
                "    store_name varchar(300) not null," +
                "    category varchar(50) not null," +
                "    address varchar(300) not null," +
                "    latitude real not null," +
                "    longitude real not null," +
                "    views integer default 0," +
                "    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "    constraint city_code foreign key(city_code) references cities(city_code) on delete cascade" +
                ");";
        statement.executeUpdate(createTable);
        createTable="create table Users(\n" +
                "    user_id serial primary key,\n" +
                "    user_name VARCHAR(50) not null,\n" +
                "    email VARCHAR(355) unique not null,\n" +
                "    password VARCHAR(50) not null,\n" +
                "    phone_number VARCHAR(20) not null,\n" +
                "    latitude REAL not null,\n" +
                "    longitude REAL not null,\n" +
                "    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
                ");";
        statement.executeUpdate(createTable);
        createTable="create table Likes(" +
                "    like_id serial primary key," +
                "    user_id integer not null," +
                "    store_id integer not null," +
                "    created_date timestamp DEFAULT CURRENT_TIMESTAMP," +
                "    constraint user_id foreign key(user_id) references users(user_id) on delete cascade," +
                "    constraint store_id foreign key(store_id) references stores(store_id) on delete cascade" +
                ");";
        statement.executeUpdate(createTable);
    }

    public void insertCities() throws SQLException {
        /* Cities */
        String[] CityList = new String[32];
        CityList[0] = "(41820,'가평군')";
        CityList[1] = "(41000,'경기도')";
        CityList[2] = "(41280,'고양시')";
        CityList[3] = "(41290,'과천시')";
        CityList[4] = "(41610,'광주시')";
        CityList[5] = "(41310,'구리시')";
        CityList[6] = "(41570,'김포시')";
        CityList[7] = "(41360,'남양주시')";
        CityList[8] = "(41410,'군포시')";
        CityList[9] = "(41250,'동두천시')";
        CityList[10] = "(41190,'부천시')";
        CityList[11] = "(41130,'성남시')";
        CityList[12] = "(41110,'수원시')";
        CityList[13] = "(41390,'시흥시')";
        CityList[14] = "(41270,'안산시')";
        CityList[15] = "(41550,'안성시')";
        CityList[16] = "(41170,'안양시')";
        CityList[17] = "(41630,'양주시')";
        CityList[18] = "(41830,'양평군')";
        CityList[19] = "(41670,'여주시')";
        CityList[20] = "(41800,'연천군')";
        CityList[21] = "(41370,'오산시')";
        CityList[22] = "(41460,'용인시')";
        CityList[23] = "(41430,'의왕시')";
        CityList[24] = "(41150,'의정부시')";
        CityList[25] = "(41500,'이천시')";
        CityList[26] = "(41480,'파주시')";
        CityList[27] = "(41220,'평택시')";
        CityList[28] = "(41650,'포천시')";
        CityList[29] = "(41450,'하남시')";
        CityList[30] = "(41590,'화성시')";
        CityList[31] = "(41210,'광명시')";


        String InsertCitiesPrefix = "insert into Cities values ";
        String CommonSuffix = ";";

//        Insert Cities
        for (String City : CityList) {
            statement.executeUpdate(InsertCitiesPrefix + City + CommonSuffix);
        }
    }

    public void insertStores() throws Exception {
        String InsertStorePrefix = "insert into Stores values ";
        int store_id = 1;
        int pIndex = 1;
        while (pIndex++ <= 533) {

            String request = StoreURL;
            request += "?" + "Key=" + apiKey;
            request += "&" + "Type=json";
            request += "&" + "pIndex=" + Integer.toString(pIndex);
            request += "&" + "pSize=1000";

            URL url = new URL(request);
            String line = "";
            String result = "";

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            int count = 0;
            while ((line = br.readLine()) != null) {
                result = result.concat(line);
                //            System.out.println(line);
            }

            //        JSONObject jsonObject = new JSONObject(result);
            //        JSONArray rawArray=jsonObject.getJSONArray("RegionMnyFacltStus");
            //        System.out.println(rawArray);

            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("RegionMnyFacltStus").getJSONObject(1).getJSONArray("row");
            //        System.out.println(jsonArray);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                //            System.out.println(obj);

                if (obj.isNull("INDUTYPE_NM")
                        || obj.isNull("INDUTYPE_NM")
                        || obj.isNull("REFINE_LOTNO_ADDR")
                        || obj.isNull("REFINE_WGS84_LAT")
                        || obj.isNull("REFINE_WGS84_LOGT")
                        || obj.isNull("SIGUN_CD")) {
                    continue;

                }

                String store_name = obj.getString("CMPNM_NM");
                String converted_store_name=store_name.replace("\'","\'\'");    // 문자열에 '가 포함되어있는 경우 처리
                store_name = converted_store_name;
                String category = obj.getString("INDUTYPE_NM");
                String address = obj.getString("REFINE_LOTNO_ADDR");
                String converted_address=address.replace("\'","\'\'");
                address=converted_address;
                float latitude = Float.parseFloat(obj.getString("REFINE_WGS84_LAT"));
                float longitude = Float.parseFloat(obj.getString("REFINE_WGS84_LOGT"));
                int city_code = Integer.parseInt(obj.getString("SIGUN_CD"));


//                StoreVO storeVO = new StoreVO();

//                storeVO.setStore_id(1);
//                storeVO.setStore_name(store_name);
//                storeVO.setCategory(category);
//                storeVO.setAddress(address);
//                storeVO.setLatitude(latitude);
//                storeVO.setLongitude(longitude);
//                storeVO.setCity_code(city_code);
//                storeVO.setViews(0);

                java.util.Date date = new Date();
                String InsertStoreSuffix = "(" + String.valueOf(store_id) + "," + String.valueOf(city_code) + ",'" + store_name + "','" + category + "','" + address + "'," + String.valueOf(latitude) + "," + String.valueOf(longitude) + ",0" + ");";

                store_id++;

                System.out.println(InsertStorePrefix + InsertStoreSuffix);

                statement.executeUpdate(InsertStorePrefix + InsertStoreSuffix);

            }
        }
    }
}