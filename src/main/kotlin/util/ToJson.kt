package test.util

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

import test.Sortie
import java.text.SimpleDateFormat
import java.util.*

class ToJson {

    //crée un json à partir d'un objet sortie
    private fun outingToJsonObject(outing : Sortie?):JsonObject{

        
        //conversion en json

        val ob  = buildJsonObject {
            put("id",outing?.getId())
            put("date",outing?.getDate())
            put("nbKilometres",outing?.getNbKilometres())
            put("duree",outing?.getDuree())
            put("avis",outing?.getAvis())
        }
      //  return Json.encodeToString(JsonObject.serializer(),ob);
        return ob;
    }

    public fun outingToJson(outing :Sortie?):String{
        return Json.encodeToString(JsonObject.serializer(),this.outingToJsonObject(outing));
    }


    public fun outingsToJson(outings : MutableList<Sortie>,nbLine : Int): String {
        //l'objet que l'on va renvoyer
        //  var outingsInJson : MutableList<String> = mutableListOf();
        var outingsInJson = buildJsonObject {
            for(i in 0 until nbLine){
                val tmpOuting = outings[i];
                put(i.toString(),outingToJsonObject(tmpOuting));
            }
         }

//        //on ajoute à la liste ts les objets sérialisés
        
            return Json.encodeToString(outingsInJson);

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