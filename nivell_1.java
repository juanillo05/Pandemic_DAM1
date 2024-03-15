// metodo split ( dividis strings a partir de un caracter ";" ) 
// arraylist 
// leerPersona.java
import java.util.ArrayList;
import java.util.Arrays;

public class nivell_1 {
    public static void main(String[] args) {

        ArrayList<String> ciudades = new ArrayList<>();


        String datos = "San Francisco;0;235,315;Chicago,Los Angeles,Manila,Tokio;" +
                       "Chicago;0;300,280;San Francisco,Montreal,Atlanta,Mexico DF,Los Angeles;" +
                       "Atlanta;0;320,320;Chicago,Miami,Washington;" +
                       "Montreal;0;350,280;Chicago,Nueva York, Washington;" +
                       "Nueva York;0;380,290;Montreal,Washington,Londres,Madrid;" +
                       "Washington;0;360,330;Montreal,Nueva York,Atlanta,Miami;" +
                       "Londres;0;700,230;Nueva York,Madrid,Paris,Essen;" +
                       "Madrid;0;687,290;Nueva York,Londres,Paris,Sao Paulo,Argel;" +
                       "Paris;0;727,250;Madrid,Londres,Essen,Argel,Milan;" +
                       "Essen;0;755,190;Londres,Paris,San Petersburgo,Milan;" +
                       "Milan;0;755,235;Essen,Paris,Estambul;" +
                       "San Petersburgo;0;815,210;Essen,Estambul,Moscu;" +
                       "Los Angeles;3;275,355;San Francisco,Mexico DF,Chicago,Sidney;" +
                       "Miami;3;380,360;Washington,Atlanta,Mexico DF,Bogota;" +
                       "Mexico DF;3;300,385;Los Angeles,Miami,Chicago,Bogota,Lima;" +
                       "Bogota;3;400,460;Miami,Mexico DF,Lima,Sao Paulo,Buenos Aires;" +
                       "Lima;3;395,520;Mexico DF,Bogota,Santiago de Chile;" +
                       "Santiago de Chile;3;430,620;Lima;" +
                       "Buenos Aires;3;453,670;Sao Paulo,Bogota;" +
                       "Sao Paulo;3;520,570;Bogota,Buenos Aires,Lagos,Madrid;" +
                       "Lagos;3;710,450;Sao Paulo,Kinsasa,Jartum;" +
                       "Kinsasa;3;770,540;Lagos,Jartum,Johannesburgo;" +
                       "Jartum;3;815,450;El Cairo,Lagos,Kinsasa,Johannesburgo;" +
                       "Johannesburgo;3;815,630;Kinsasa,Jartum;" +
                       "Argel;2;730,330;Madrid,Paris,Estambul,El Cairo;" +
                       "El Cairo;2;820,350;Argel,Estambul,Bagdad;" +
                       "Riad;2;895,385;El Cairo,Bagdad,Karachi;" +
                       "Estambul;2;830,294;Argel,El Cairo,Bagdad,Moscu;" +
                       "Bagdad;2;880,320;Estambul,Karachi,Riad,El Cairo;" +
                       "Moscu;2;890,230;Teheran,Estambul,San Petersburgo;" +
                       "Teheran;2;920,310;Moscu,Bagdad,Karachi,Nueva Delhi;" +
                       "Karachi;2;980,355;Teheran,Bagdad,Nueva Delhi,Riad,Bombay;" +
                       "Bombay;2;1005,395;Karachi,Nueva Delhi,Madras;" +
                       "Nueva Delhi;2;1025,330;Teheran,Karachi,Bombay,Madras,Calcuta;" +
                       "Calcuta;2;1070,370;Nueva Delhi,Hong Kong,Madras,Bangkok;" +
                       "Madras;2;1035,410;Bombay,Nueva Delhi,Calcula,Bangkok,Yakarta;" +
                       "Bombay;2;1005,395;Karachi,Madras,Nueva Delhi;" +
                       "Yakarta;1;1150,525;Madras,Bangkok,Ho Chi Minh,Sidney;" +
                       "Bangkok;1;1120,415;Yakarta,Calcuta,Madras,Ho Chi Minh,Hong Kong;" +
                       "Hong Kong;1;1165,370;Bangkok,Ho Chi Minh,Taipei,Manila,Shanghai;" +
                       "Shanghai;1;1195,355;Pekin,Hong Kong,Seul,Tokio,Taipei;" +
                       "Pekin;1;1175,300;Seul,Shanghai;" +
                       "Seul;1;1225,297;Pekin,Tokio;" +
                       "Tokio;1;1280,290;San Francisco,Seul,Osaka,Shanghai;" +
                       "Osaka;1;1255,320;Tokio,Taipei;" +
                       "Taipei;1;1205,375;Osaka,Shanghai,Hong Kong,Manila;" +
                       "Ho Chi Minh;1;1148,429;Yakarta,Bangkok,Hong Kong,Manila;" +
                       "Manila;1;1200,420;San Francisco,Ho Chi Minh,Taipei,Hong Kong,Sidney;" +
                       "Sidney;1;1320,645;Los Angeles,Manila,Yakarta;";

       
        String[] ciudadesDatos = datos.split(";");


        for (int i = 0; i < ciudadesDatos.length; i += 4) {

            String ciudad = ciudadesDatos[i];
            ciudades.add(ciudad);

   
            String[] numerosStr = ciudadesDatos[i + 2].split(",");
            StringBuilder numeros = new StringBuilder();
            for (int j = 0; j < numerosStr.length; j++) {
                numeros.append(numerosStr[j]);
                if (j < numerosStr.length - 1) {
                    numeros.append(", ");
                }
            }

         
            String[] ciudadesColindantes = ciudadesDatos[i + 3].split(",");
            StringBuilder ciudadesColindantesStr = new StringBuilder();
            for (int j = 0; j < ciudadesColindantes.length; j++) {
                ciudadesColindantesStr.append(ciudadesColindantes[j]);
                if (j < ciudadesColindantes.length - 1) {
                    ciudadesColindantesStr.append(", ");
                }
            }

   
            String frase = "Silco actúa en " + ciudad + " con los números " + numeros.toString() +
                           ", y cuyas ciudades colindantes son " + ciudadesColindantesStr.toString();


            System.out.println(frase);
        }
    }
}


