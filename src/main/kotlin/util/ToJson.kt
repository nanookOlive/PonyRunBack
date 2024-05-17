package test.util

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

import test.Sortie
import java.text.SimpleDateFormat
import java.util.*

class ToJson {

    //crée un json à partir d'un objet sortie
    public fun outlingToJson(outling : Sortie?):String{

        //convertir tous les attributs de outling
        val id : Int? = (outling?.getId())?.toInt();
       // val date : Date? = convertDate(outling.getDate());
        val nbKilometres : Float?= (outling?.getNbKilometres())?.toFloat();
        val duree : Int? = (outling?.getDuree())?.toInt();

        //conversion en json

        val ob  = buildJsonObject {
            put("id",id)
            put("date",outling?.getDate())
            put("nbKilometres",nbKilometres)
            put("duree",duree)
            put("avis",outling?.getAvis())
        }

        return Json.encodeToString(JsonObject.serializer(),ob);



    }

    private fun convertDate(date : String?):Date?{


        val format : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy");
        var dateDate : Date?;
        try{
            dateDate = format.parse(date);
        }catch(exception : Exception){
            dateDate=null;
        }

        return dateDate;
    }
}