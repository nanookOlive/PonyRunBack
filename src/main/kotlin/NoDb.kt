package test

import java.io.*


class NoDb {

    public var message : String? ="";
    private val PATH = "src/main/db.txt";

    //renvoie  l'itérable avec le contenu de de db.txt
    private  fun getBuffererdReader():BufferedReader?{
        try{

            val file : File = File(this.PATH);
            if(file.exists()){
                val reader : FileReader = FileReader(file);
                val handler : BufferedReader = BufferedReader(reader);
                return handler;
            }else{
                this.message="DB.TXT NOT FOUND";
                return null;
            }
        }catch(exception :IOException) {

            this.message=exception.message;
            return null;
        }
    }

    //errorhandler


    //Renvoie les les éléments que l'on souhaite à partir d'un id
    public fun findById(id : String,value : String? = null):String?{
        //on récupère le contneu du db.txt
        val iterableContent : BufferedReader? = this.getBuffererdReader();
        var resultat : String? = null;
        var line :String?= null;
        //on boucle pour le lire
        while(iterableContent?.readLine().also { line = it } != null){

           //call method String to map
            val lineIntoMap = this.lineIntoMap(line);
           // this.message = lineIntoMap["id"];
            if(lineIntoMap["id"] == id) {
               when(value){

                   "citation" -> resultat=lineIntoMap["citation"];
                   "auteur" -> resultat=lineIntoMap["auteur"];
                   null -> resultat="ERROR YOU DONT SPECIFY VALUE.";
               }
            }
        }
        return resultat;

    }
    //inscrire

    //supprimer

    public fun echo():String{
        return "works fine !";
    }
//renvoie les éléments d'une ligne sous la forme d'un ensemble clé valeur
    private fun lineIntoMap(line :String?):MutableMap<String,String>{
        var lineIntoMap : MutableMap<String,String> = mutableMapOf();
        //on split la string
        if(line != null){

            var lineIntoList :List<String> = line.split(";");
            //on assigne ele n => id, citation, auteur dans la map
            lineIntoMap["id"]=lineIntoList[0];
            lineIntoMap["citation"]=lineIntoList[1];
            lineIntoMap["auteur"]=lineIntoList[2];

        }
        return lineIntoMap;

    }

    //renvoie un objet sortie à partir d'une ligne

}