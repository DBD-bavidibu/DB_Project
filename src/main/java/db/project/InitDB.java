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
    private String DBURL = "jdbc:postgresql://localhost:5432/db_project";
    private String DBUser = "postgres";
    private String DBPassword = "blackapple";

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
    
    public void insertUsers() throws SQLException {
        /* Users */
        String[] UserList = new String[100];
        UserList[0] = "(10,'안정원','jw123@naver.com','wjddnjs',01033760312,37.295345,126.968961)";
        UserList[1] = "(11,'이익준','dlrwns@gmail.com','dlrwnsdl323',01024241133,37.408604,127.126873)";
        UserList[2] = "(12,'전미도','mido@naver.com','wjsaleh123',01015881589,37.347624,127.113774)";
        UserList[3] = "(41,'jake','jk@naver.com','123456123456',0100022223,37.299812,127.044918)";
        UserList[4] = "(12907,'폴','wlsn@naver.com','pp1231234',01088445566,37.358098,126.968241)";
        UserList[5] = "(29111,'한나아','jew@naver.com','pdfczczxpp',01000221155,37.254134, 127.222111)";
        UserList[6] = "(21116,'정준이','jooni@gmail.com','ppzxczxczx',01012124545,37.290812,127.255334)";
        UserList[7] = "(12385,'하지원','jssd@gmail.com','asdasdpp',01064654654,37.358098,126.968241)";
        UserList[8] = "(2860,'정준아','wnsdkdl@naver.com','wnsdkfkdshfwk',01054545454,37.347624,127.113774)";
        UserList[9] = "(4422,'김지원','wldnjs@nate.com','wldnjs123',01055448877,37.157384,127.061607)";
        UserList[10] = "(17748,'중우안','wnddndks@naver.com','wsldkfnpp',01012251225,37.157384,127.061607)";
        UserList[11] = "(8761,'양희은','didgmldms@nate.com','gmldmssd',01012124846,37.157384,127.061607)";
        UserList[12] = "(16912,'준희은','wnsgmldms@naver.com','pp123123',01033112222,37.157384,127.061607)";
        UserList[13] = "(18844,'노홍철','noh@naver.com ','sh123456',01078914567,37.402212 ,127.110001)";
        UserList[14] = "(7218,'강심장','rkd@gmail.com','rkd1234578',01098765432,37.285461,127.258525)";
        UserList[15] = "(25092,'김구라','rnfk@hanmail.com','rnfkdi',01078519621,37.124841,127.879451)";
        UserList[16] = "(14210,'이은자','dmds@kaka.com','1dmsdk1',01084627591,37.254812,127.986452)";
        UserList[17] = "(25373,'김지은','rl@nate.com','dfdaaaa',01096385214,37.558844,128.001155)";
        UserList[18] = "(14650,'강지은','rkdd@yahoo.com','1245rkdwl',01078940231,37.154865,126.285412)";
        UserList[19] = "(21636,'박신','qkr@woorie.com','qkrwkdl',01084613125,37.998855,125.112233)";
        UserList[20] = "(28784,'자우니','dnsl@kyobo.com','dnsl123456',010998877,36.115544,128.112233)";
        UserList[21] = "(16190,'김지연','qkrwldk@hanab.com','qkrwlsld',0107894562,36.154681,125.121345)";
        UserList[22] = "(26450,'장소은','soso@ajou.ac.kr','wldkfn',01033110222,36.154681,125.121345)";
        UserList[23] = "(32017,'김두아','dudu@naver.com','dnfldk',01033334444,36.134681,125.120025)";
        UserList[24] = "(28560,'바오라','baocme@gmail.com','sdfsd',01011223344,36.124681,125.021345)";
        UserList[25] = "(9165,'가나다','rkskek@hanmail.com','asdfdfd',01022334455,36.161681,125.202156)";
        UserList[26] = "(12058,'주아니','money@kaka.com','qweqweq',01033445566,36.158681,125.124455)";
        UserList[27] = "(29588,'모니모','nemo@nate.com','asdasd',01022334466,36.159881,125.021355)";
        UserList[28] = "(6068,'강지아','znnnnn@yahoo.com','sdsdsdsd',01044556677,36.194681,125.151312)";
        UserList[29] = "(10399,'김희철','heeee@woorie.com','zxcvcvc',01011553322,37.057384,127.081607)";
        UserList[30] = "(18471,'김윤아','yuun@kyobo.com','eeerrrr',01010203939,37.058384,127.261607)";
        UserList[31] = "(21540,'박상원','s11d@hanab.com','qazwsx',01092933847,37.158884,126.061607)";
        UserList[32] = "(3107,'박상윤','suang@ajou.ac.kr','xswqaz',01009897654,37.157384,127.061607)";
        UserList[33] = "(15667,'최현지','guswl@naver.com ','wersdf',01011443322,37.025384, 127.081607)";
        UserList[34] = "(6157,'박지은','jiai@gmail.com','qweasd',01099446611,37.328098,126.868241)";
        UserList[35] = "(4558,'강은아','didi@hanmail.com','zxccvb',0108791787,37.258298,126.982241)";
        UserList[36] = "(18505,'이은샘','seurm@kaka.com','rrrttt',01099880753,37.058098,126.968248)";
        UserList[37] = "(12690,'차은아','aoa@nate.com','qazedc',01011228802,37.200098,126.718241)";
        UserList[38] = "(10173,'사오라','come@yahoo.com','wsxedc',01033776644,37.458098,126.958241)";
        UserList[39] = "(26262,'여기여','here@woorie.com','rfvtgb',01022778833,37.352022,127.668241)";
        UserList[40] = "(24492,'지은새','bird@kyobo.com','werdsdf',01000882255,37.351298,126.968541)";
        UserList[41] = "(18041,'비은새','dmdfkdnf@hanab.com','qwerty',01088664455,37.358058,127.168241)";
        UserList[42] = "(786,'바은새','dmsdkf@ajou.ac.kr','tgbrfc',01033994455,37.351098,126.228241)";
        UserList[43] = "(1209,'배용새','dystp@naver.com ','werffv',0106621155,37.458098,126.923241)";
        UserList[44] = "(31266,'배용준','dydwns@gmail.com','tgbyhn',01015880484,36.358098,126.968251)";
        UserList[45] = "(2234,'김수지','tnwsdfn@hanmail.com','1ss2345678',01112211550,37.310098,127.178241)";
        UserList[46] = "(13990,'배수니','tnwldk@kaka.com','qweddfd1',01099784465,37.308078,125.168241)";
        UserList[47] = "(27957,'박철수','cjftn@nate.com','sss11123',01011220022,36.528098,125.168241)";
        UserList[48] = "(24642,'신짜욱','wkdnr@yahoo.com','ppasd3246',01099663388,37.328198,126.068241)";
        UserList[49] = "(31712,'신자릉','wkfmd@woorie.com','gg11233',01055116644,37.212098,126.118241)";
        UserList[50] = "(24554,'장리아','fldk@kyobo.com','alkdnfl',01088446611,37.310208,126.921341)";
        UserList[51] = "(3979,'방바울','qkdnf@hanab.com','dystodk',01099663355,36.358098,127.908241)";
        UserList[52] = "(11288,'한요샘','dytoq@ajou.ac.kr','rhfudi',01088442200,36.350598,127.846541)";
        UserList[53] = "(22546,'주아연','dusdl12d@naver.com ','dkwndi',01011992299,36.351298,127.234241)";
        UserList[54] = "(886,'박구리','rnfl@gmail.com','dkwndidlf',01059582562,36.313598,127.891241)";
        UserList[55] = "(5828,'너구리','sjrnfl@hanmail.com','tndtlf',01013467946,36.358098,127.108241)";
        UserList[56] = "(29213,'산우낭','tksdnsk@kaka.com','dbslqj',01079582461,37.358098,126.008241)";
        UserList[57] = "(24378,'배고프','qorhvm@nate.com','tlxlfh',01013122312,36.358098,127.184611)";
        UserList[58] = "(7581,'아오라','aoud197@yahoo.com','rkwlfkdnf',01011223123,36.358098,127.124611)";
        UserList[59] = "(1970,'김한슬','seul102@woorie.com','tpwhdoe',01011221324,36.358098,126.184611)";
        UserList[60] = "(30309,'박두한','123ddff@kyobo.com','whddhdd',01019283544,36.121246,127.184611)";
        UserList[61] = "(3430,'강대한','deahahd@hanab.com','wndkdndlkd',01028345612,36.358000,127.184611)";
        UserList[62] = "(8517,'강민국','ekfld@ajou.ac.kr','dddfddd',01085296396,36.358008,127.180601)";
        UserList[63] = "(5240,'송민국','mindddff@naver.com ','wnddkdeo',01013467946,36.351098,126.155611)";
        UserList[64] = "(16923,'송만세','andm@gmail.com','rkrhtlvsl',01085258585,36.328098,127.084611)";
        UserList[65] = "(10350,'송지은','jinind@hanmail.com','dklsdkfn',01000331122,36.358098,127.180611)";
        UserList[66] = "(22773,'송대한','dehh@kaka.com','wndgkld',01099559955,36.358098,127.000001)";
        UserList[67] = "(18765,'장지현','wldnfdk@nate.com','sldkfnslkdnf',01012124545,36.358098,127.020001)";
        UserList[68] = "(11563,'박지현','wlgusdk@yahoo.com','dptnfdlkfs',01052524414,36.311198,127.110001)";
        UserList[69] = "(29399,'천인우','dlsdn@woorie.com','dddffffd',01088995566,36.258098,127.000001)";
        UserList[70] = "(24112,'차예린','ddfd@kyobo.com','12332233',01018484848,36.358098,127.055001)";
        UserList[71] = "(30332,'청주아','wndlsk@hanab.com','aaasssdd',01075748475,36.358098,127.123451)";
        UserList[72] = "(12350,'박주원','dnjsl@ajou.ac.kr','zzzxxxccc',01011220005,36.358098,127.012101)";
        UserList[73] = "(1527,'손호준','ghwnsl@naver.com ','rrrtttyyy',01099663354,36.358098,127.112201)";
        UserList[74] = "(6914,'임윤아','dbskdb@gmail.com','dddcccxxx',01015884848,36.358098,127.000000)";
        UserList[75] = "(31663,'제시카','tl@hanmail.com','edrfvtgbb',01020215484,36.355228,127.131311)";
        UserList[76] = "(4843,'티파니','vksl@kaka.com','ssdfsdf',01031649794,36.358098,126.900001)";
        UserList[77] = "(5978,'성유리','dbfl@nate.com','xxcvxcv',01075124851,36.128098,127.920001)";
        UserList[78] = "(2520,'이효리','flgy@yahoo.com','zxczxcz',01012225992,36.158098,127.024001)";
        UserList[79] = "(22638,'옥주현','wngusl@woorie.com','asdasdas',01002035649,36.158098,127.008801)";
        UserList[80] = "(18987,'김수만','tnak@kyobo.com','bvbvbcv',01022448866,36.123545,127.115544)";
        UserList[81] = "(11621,'박지년','nyer@hanab.com','tgtgtgrrf',01094612245,36.358098,127.000001)";
        UserList[82] = "(10133,'구자철','jach@ajou.ac.kr','sdfsdfsd',01096205154,36.358098,127.000221)";
        UserList[83] = "(9699,'기성용','you@naver.com ','sdfsdf',01056181564,36.358098,127.022001)";
        UserList[84] = "(6926,'한혜찐','jinji@gmail.com','sdfsdf',01075877845,36.322098,127.000001)";
        UserList[85] = "(1849,'박은바','eunbaa@hanmail.com','sdfsdf',01073731313,36.358098,127.001101)";
        UserList[86] = "(19425,'메로나','mero@kaka.com','sdfsdfsds',01088445555,36.358098,127.000201)";
        UserList[87] = "(24032,'주안은','dksdms2@nate.com','asdasdas',01013139595,36.358898,127.000001)";
        UserList[88] = "(21933,'김은혜','dmsgP1@yahoo.com','eqweqeqw',01085882101,36.358098,127.202081)";
        UserList[89] = "(15322,'하정아','gddkwjd@woorie.com','qweqwe',01020162154,36.358098,127.987001)";
        UserList[90] = "(23492,'하정우','ghandk@kyobo.com','hfghfghfg',01020200514,36.358098,127.012301)";
        UserList[91] = "(4899,'주지훈','wnwn@hanab.com','bcvbcvbcvb',01020255655,36.358098,127.5465001)";
        UserList[92] = "(15456,'문근영','anan@ajou.ac.kr','ssdfsdfds',01021634511,36.312458,127.000001)";
        UserList[93] = "(21649,'소지섭','thth@naver.com ','erwerewrw',01021344444,37.358098,127.000001)";
        UserList[94] = "(2677,'이하늘','dldl@gmail.com','sfsdfsdfs',01015554444,36.358098,127.000001)";
        UserList[95] = "(32472,'김하늘','haha@hanmail.com','asdasdas',01021155555,36.358098,127.000001)";
        UserList[96] = "(27441,'정유미','euri@kaka.com','qqqwwwe',01077441122,36.358098,127.001101)";
        UserList[97] = "(26254,'에릭','eu@nate.com','rrrrersd',01033778844,36.358098,127.222001)";
        UserList[98] = "(7276,'아이유','dldb@yahoo.com','xcvxcvc',01022884499,36.358098,127.1845001)";
        UserList[99] = "(1887,'비욘자','qldys@woorie.com','asdads',01003162244,36.358098,127.115401)";
   


        String InsertUsersPrefix = "insert into Users values ";
        String CommonSuffix = ";";

//        Insert Users
        for (String User : UserList) {
            statement.executeUpdate(InsertUsersPrefix + User + CommonSuffix);
        }
       
    }

    public void insertLikes() throws SQLException {
        /* Likes 
         * like_id , user_id, store_id, created_date
         * */
    	String[] LikeList = new String[116];
        LikeList[0] = "(10,148710)";
        LikeList[1] = "(1887,143991)";
        LikeList[2] = "(2860,142316)";
        LikeList[3] = "(2860,92429)";
        LikeList[4] = "(29111,97548)";
        LikeList[5] = "(4422,142316)";
        LikeList[6] = "(1887,142316)";
        LikeList[7] = "(41,78518)";
        LikeList[8] = "(16912,78518)";
        LikeList[9] = "(18844,78518)";
        LikeList[10] = "(9165,78518)";
        LikeList[11] = "(18505,78518)";
        LikeList[12] = "(28560,81336)";
        LikeList[13] = "(9165,81336)";
        LikeList[14] = "(12058,81336)";
        LikeList[15] = "(3107,81336)";
        LikeList[16] = "(18505,81591)";
        LikeList[17] = "(6157,81591)";
        LikeList[18] = "(27957,81591)";
        LikeList[19] = "(6157,81588)";
        LikeList[20] = "(3107,81588)";
        LikeList[21] = "(10,141550)";
        LikeList[22] = "(11,141550)";
        LikeList[23] = "(12,141550)";
        LikeList[24] = "(41,141550)";
        LikeList[25] = "(12907,141550)";
        LikeList[26] = "(21116,141550)";
        LikeList[27] = "(18471,141550)";
        LikeList[28] = "(21540,141550)";
        LikeList[29] = "(12058,141550)";
        LikeList[30] = "(29588,141550)";		
        LikeList[31] = "(31266,141550)";
        LikeList[32] = "(13990,141550)";
        LikeList[33] = "(5240,141550)";
        LikeList[34] = "(22773,141550)";
        LikeList[35] = "(11563,141550)";
        LikeList[36] = "(29399,141550)";
        LikeList[37] = "(1527,141550)";
        LikeList[38] = "(31663,141550)";
        LikeList[39] = "(6914,141550)";
        LikeList[40] = "(12350,141550)";
        LikeList[41] = "(30332,141550)";
        LikeList[42] = "(4843,141550)";
        LikeList[43] = "(5978,141550)";
        LikeList[44] = "(2520,141550)";
        LikeList[45] = "(22638,141550)";
        LikeList[46] = "(18987,141550)";
        LikeList[47] = "(11621,141550)";
        LikeList[48] = "(10133,141550)";
        LikeList[49] = "(9699,141550)";
        LikeList[50] = "(6926,141550)";
        LikeList[51] = "(26254,141550)";
        LikeList[52] = "(11,141550)";
        LikeList[53] = "(12,141550)";
        LikeList[54] = "(41,141550)";
         LikeList[55] = "(12907,141550)";
         LikeList[56] = "(21933,141550)";
        LikeList[57] = "(15322,141550)";
        LikeList[58] = "(27441,141550)";
        LikeList[59] = "(26254,141264)";
        LikeList[60] = "(21649,141264)";
        LikeList[61] = "(2677,141264)";
        LikeList[62] = "(1887,141264)";
        LikeList[63] = "(41,141264)";
        LikeList[64] = "(6926,141264)";
        LikeList[65] = "(27441,141264)";
        LikeList[66] = "(21649,141264)";
        LikeList[67] = "(10,141264)";
        LikeList[68] = "(8761,141264)";
        LikeList[69] = "(21649,140045)";
        LikeList[70] = "(2677,140045)";
        LikeList[71] = "(1887,140045)";
        LikeList[72] = "(15456,140045)";
        LikeList[73] = "(7276,140045)";
        LikeList[74] = "(10,140045)";
        LikeList[75] = "(7218,140045)";
        LikeList[76] = "(14210,140045)";
        LikeList[77] = "(16190,140045)";
        LikeList[78] = "(10,143197)";
        LikeList[79] = "(7276,143197)";
        LikeList[80] = "(4899,143197)";
        LikeList[81] = "(16190,143197)";
        LikeList[82] = "(4558,143197)";
        LikeList[83] = "(18505,143197)";
        LikeList[84] = "(24492,143197)";
        LikeList[85] = "(12690,143197)";
        LikeList[86] = "(6157,143197)";
        LikeList[87] = "(21540,143197)";
        LikeList[88] = "(10399,143197)";
        LikeList[89] = "(7276,144112)";
        LikeList[90] = "(4899,144112)";
        LikeList[91] = "(16190,144112)";
        LikeList[92] = "(4558,144112)";
        LikeList[93] = "(18505,144112)";
        LikeList[94] = "(24492,144112)";
        LikeList[95] = "(12690,144112)";
        LikeList[96] = "(21540,144112)";
        LikeList[97] = "(10173,144112)";
        LikeList[98] = "(10399,144112)";
        LikeList[99] = "(28560,144112)";
        LikeList[100] = "(12058,144112)";
        LikeList[101] = "(18471,144112)";
        LikeList[102] = "(7218,144112)";
        LikeList[103] = "(14210,144112)";
        LikeList[104] = "(21636,144112)";
        LikeList[105] = "(6157,144112)";
        LikeList[106] = "(10,144112)";
        LikeList[107] = "(21649,144112)";
        LikeList[108] = "(23492,144112)";
        LikeList[109] = "(4899,136953)";
        LikeList[110] = "(16190,136953)";
        LikeList[111] = "(4558,136953)";
        LikeList[112] = "(18505,136953)";
        LikeList[113] = "(12690,136953)";
        LikeList[114] = "(24492,136953)";
        LikeList[115] = "(10173,136953)";
        
        String InsertLikesPrefix = "insert into Likes(user_id, store_id) values ";
        String CommonSuffix = ";";

//        Insert Likes
        for (String Like : LikeList) {
            statement.executeUpdate(InsertLikesPrefix + Like + CommonSuffix);
        }
        String createTable="create view StoreInfo as"+
        		"select * from (select store_id, count(like_id) as likes_num from likes group by store_id) as l"+
        		"full outer join"+
        		"stores using(store_id);";
        statement.executeUpdate(createTable);
    }
}