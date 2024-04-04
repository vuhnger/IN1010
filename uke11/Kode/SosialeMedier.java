public class SosialeMedier {
    
    String[] sosialeMedier = {
        "Snapchat",
        "TikTok",
        "Instagram",
        "Facebook"
    };

    public boolean finnesSosialMedium(String medium){
        // Prekondisjon: "medium"-strengen kan jo ikke være null!
        if (medium == null){
            throw new IllegalArgumentException("[FEIL] `medium` kan ikke være null! ");
        }

        for (int i = 0; i < sosialeMedier.length; i++){
            if (sosialeMedier[i].equals(medium)){
                return true;
            }
        }
        return false;
    }
}
