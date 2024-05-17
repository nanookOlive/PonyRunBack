package test

import java.io.*


class NoDb {

    public var message : String? ="";
    private val PATH = "src/main/db.txt";
    private val data : MutableList<Sortie> ;
    private var nbLines : Int=0;

    constructor(){
        data = this.getAllOuting();
    }

    public fun getData():MutableList<Sortie>{
        return this.data;
    }
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


    public fun findOutingById(id : String):Sortie?{

        var sortie: Sortie? = null;

        //on boucle sur data
        for(so in this.data){
            if(so.getId() == id){
                sortie=so;
            }
        }
        return sortie;
    }

    //inscrire

    //supprimer


    //renvoie les éléments d'une ligne sous la forme d'un ensemble clé valeur
    private fun lineIntoMap(line :String?):MutableMap<String,String>{
        var lineIntoMap : MutableMap<String,String> = mutableMapOf();
        //on split la string
        if(line != null){

            var lineIntoList :List<String> = line.split(";");
            //on assigne ele n => id, citation, auteur dans la map
            lineIntoMap["id"]=lineIntoList[0];
            lineIntoMap["date"]=lineIntoList[1];
            lineIntoMap["distance"]=lineIntoList[2];
            lineIntoMap["duration"]=lineIntoList[3];
            lineIntoMap["rating"]=lineIntoList[4];

        }
        return lineIntoMap;

    }

    //renvoie un objet sortie à partir d'une ligne

    public fun getAllOuting():MutableList<Sortie>
    {
        var allOutings : MutableList<Sortie> = mutableListOf<Sortie>();
        var line : String? =null;
        this.nbLines=0;
        //on récupère l'ensemble des données
        val iterableContent : BufferedReader? = this.getBuffererdReader();
        while(iterableContent?.readLine().also{ line =it } !=null){

            val splitedLine : MutableMap<String,String> = lineIntoMap(line);
            //on instancie un objet sortie

            var tmpOuting = Sortie(
                splitedLine["id"],
                splitedLine["date"],
                splitedLine["distance"],
                splitedLine["duration"],
                splitedLine["rating"]
            );

            allOutings.add(tmpOuting);
            this.nbLines++;
        }
        return allOutings;
    }

    public fun getNbLines():Int
    {
        return this.nbLines;
    }


}