/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Employe;
import service.Service;

/**
 *
 * @author sperret
 */
public class ConsulterProfilAstralSerialisation extends Serialisation {
    public ConsulterProfilAstralSerialisation(Service service) {
        super(service);
    }

    @Override
    public void appliquer(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("[TEST] Execution de ProfilEmployeSerialisation");
        res.setContentType("predictif/json;charset=UTF-8");
        
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        
        JsonObject clientJson = new JsonObject();
        clientJson.addProperty("idClient", (Long) req.getAttribute("idClient"));
        clientJson.addProperty("nom", (String) req.getAttribute("nom"));
        clientJson.addProperty("prenom", (String) req.getAttribute("prenom"));
        clientJson.addProperty("animal", (String) req.getAttribute("animal"));
        clientJson.addProperty("zodiaque", (String) req.getAttribute("zodiaque"));
        clientJson.addProperty("couleur", (String) req.getAttribute("couleur"));
        clientJson.addProperty("chinois", (String) req.getAttribute("chinois"));

        PrintWriter out = res.getWriter();
        out.println(gson.toJson(clientJson));
        out.close();

        System.out.println("[TEST] Execution de ProfilEmployeSerialisation");
    }
}