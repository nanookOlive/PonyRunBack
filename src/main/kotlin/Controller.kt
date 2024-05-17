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
import test.util.ToJson


@Path("/test")
class Controller {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/first")
    public fun test():String {

        val db: NoDb = NoDb();


        val outing = db.findOutlingById("11");

        val util = ToJson();
        return util.outlingToJson(outing)
    }

    /**
     * get toutes les sorties tableau d'objets sortie
     *
     * post nouvelle sortie
     */



}