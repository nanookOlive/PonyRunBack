package test

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import org.slf4j.helpers.Util
import test.util.ToJson


@Path("/sortie")
class Controller {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{id}")
    public fun test(id:String):String {

        val db: NoDb = NoDb();
        val outing = db.findOutingById(id);
        val util = ToJson();
        return util.outingToJson(outing)
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public fun getAllOutings():String{

        val db : NoDb = NoDb();
        val outings = db.getAllOuting();//
        val util = ToJson();
        val nb : Int =  db.getNbLines();
        return util.outingsToJson(outings,nb);



    }
    /**
     * get toutes les sorties tableau d'objets sortie
     *
     * post nouvelle sortie
     */

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/nbLines")
    public fun nbLine():String{

        val db = NoDb();
        return (db.getNbLines()==16).toString();

    }

}