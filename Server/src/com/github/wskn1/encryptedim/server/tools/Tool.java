package org.wsk.crypto.encrypt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

public class Tool {
    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));

            String s = null;



            while((s = reader.readLine()) != null){

                sb.append(s);

            }

        } catch (Exception e) {
            // TODO 自动生成的 catch 块



        }


        return sb.toString();
    }
    public static String GetMac()
    {
        InetAddress ia;
        byte[] mac = null;
        try {
            //获取本地IP对象
            ia = InetAddress.getLocalHost();
            //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
            mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<mac.length;i++){
            if(i!=0){
                sb.append("-");
            }
            //mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length()==1?0+s:s);
        }

        //把字符串所有小写字母改为大写成为正规的mac地址并返回
        return sb.toString().toUpperCase();
    }

    public static String shuffleString(String str){
        char[] tmp = str.toCharArray();
        Character[] tmp2 = new Character[str.length()];
        for(int i = 1 ; i <= str.length() ; i++){
            tmp2[i - 1] = tmp[i - 1];
        }
        List<Character> charList = Arrays.asList(tmp2);
        Collections.shuffle(charList);
        for(int i = 1 ; i <= charList.size() ; i++){
            tmp[i - 1] = charList.get(i - 1);
        }
        return new String(tmp);
    }

}
