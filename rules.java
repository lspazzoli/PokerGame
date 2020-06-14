public class rules {

   // private card[] cards;
    private static int[] value;

    public static String handStrengthPoker(card[] cards) {
    {
        value = new int[4];
        int[] ranks = new int[14];
        int[] orderedRanks = new int[5];
        boolean flush=true, straight=false;
        String result="";
        int sameCards=1,sameCards2=1;
        int largeGroupRank=0,smallGroupRank=0;
        int index=0;
        for (int x=0; x<=3; x++){
            value[x]=0;}

        for (int x=0; x<=13; x++)
        {
            ranks[x]=0;
        }
        for (int x=0; x<=4; x++)
        {
            ranks[ cards[x].getValue() ]++;
        }
        
        //Flush Check
        for (int x=0; x<4; x++) {
            if ( cards[x].getSuit() != cards[x+1].getSuit() )
                flush=false;}

        for (int x=13; x>=1; x--) {
                 if (ranks[x] > sameCards){
                     if (sameCards != 1){
                         sameCards2 = sameCards;
                         smallGroupRank = largeGroupRank;}

                     sameCards = ranks[x];
                     largeGroupRank = x;
                 } else if (ranks[x] > sameCards2){
                     sameCards2 = ranks[x];
                     smallGroupRank = x;}
        }
        
        //Ace Check
        if (ranks[1]==1){
            orderedRanks[index]=14;
            index++;}
        for (int x=13; x>=2; x--){
            if (ranks[x]==1){
                orderedRanks[index]=x;
                index++;}}
        
        //Check For Straight
        for (int x=1; x<=9; x++){
            if (ranks[x]==1 && ranks[x+1]==1 && ranks[x+2]==1 && 
                ranks[x+3]==1 && ranks[x+4]==1){
                straight=true;
                break;}}
        
      //Check For Straight with Ace
        if (ranks[10]==1 && ranks[11]==1 && ranks[12]==1 && 
            ranks[13]==1 && ranks[1]==1){
            straight=true;
            }
        
        //start hand evaluation
        //High Cards
        if ( sameCards==1 ) {
            value[0]=1;
            result="High Cards";}
        //One Pair
        if (sameCards==2 && sameCards2==1){
            value[0]=2;
            value[1]=largeGroupRank;
        	result="One Pair of " +  cards[0].rankAsString(value[1])+"'s";}
        //Two Pair
        if (sameCards==2 && sameCards2==2){
            value[0]=3;
            value[1]= largeGroupRank ;
            value[2]=  smallGroupRank;result="Two Pair of " + cards[0].rankAsString(value[1])+"'s  &  "+cards[0].rankAsString(value[2])+"'s";}
        //Three of a Kind
        if (sameCards==3 && sameCards2!=2){
            value[0]=4;
            value[1]= largeGroupRank;
        	result="Three of a Kind "+cards[0].rankAsString(value[1])+"'s";}
        //Straight
        if (straight && !flush){
            value[0]=5;
        	result="Straight";}
        //Flush
        if (flush && !straight){
            value[0]=6;
        	result="Flush";}
        //Full House
        if (sameCards==3 && sameCards2==2){
            value[0]=7;
            value[1]=largeGroupRank;
            value[2]=smallGroupRank;
        	result="Full House";}
        //Four of a Kind
        if (sameCards==4){
            value[0]=8;
            value[1]=largeGroupRank;
        	result="Four of a Kind "+cards[0].rankAsString(value[1])+"'s";}
        //Straight Flush
        if (straight && flush){
            value[0]=9;
        	result="Straight Flush";}

    	return result;
    	}
    }


}
