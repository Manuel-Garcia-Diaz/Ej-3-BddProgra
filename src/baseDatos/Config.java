/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Breyner
 */
public class Config {
    private Properties props;

    
    public Config() {
        props = new Properties();
        try {
            // Cargamos el archivo
         /*   FileInputStream fis = new FileInputStream("config.properties");*/
         InputStream fis = getClass().getClassLoader().getResourceAsStream("propiedades/config.properties");
                           
            if (fis == null) {
                System.out.println("Error: No se encontró el archivo config.properties");
                return;
            }

            // 4. Lee el contenido y lo guarda en memoria
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProp(String clave) {
        return props.getProperty(clave);
    }
}
