package test

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.io.BufferedReader
import java.io.File

@Path("/test")
class Controller {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/first")
    public fun test():String?{

        val db: NoDb = NoDb();

        //return content?.readLine();
        val res : String? =db.findById("3","citation");
        val all = db.getAllOuting();

        return all.toString();
    }

    /**
     * get toutes les sorties tableau d'objets sortie
     *
     * post nouvelle sortie
     */



}