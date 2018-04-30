package com.test.modelgenrator;

public class RestMessageGenerator {

    //take from file or from internet  live feed
    //add timestamp for readability

    static String[] rest={"GET http://10.22.11.122:8082/ws/v1/cluster/info/",
                "GET http://10.22.11.122:8082/ws/v1/cluster/scheduler/",
                "GET http://10.22.11.122:8082/ws/v1/cluster/scheduler/",
                "POST http://10.22.11.122:8082/ws/v1/cluster/apps/application_21010020_234/",
                "POST http://10.22.11.122:8082/ws/v1/cluster/apps/application_21010020_234/"};

    static String[]  resource={"as22s12123","khk3dw","y485nfg","a785nkg","a8875bbbv"};


    public static  String  getMessage(){
        int random1 = (int )(Math.random() * 4 + 0);
        int random2 = (int )(Math.random() * 4 + 0);


        String concatenated= rest[random1] + resource[random2];

        return concatenated;
    }
}
