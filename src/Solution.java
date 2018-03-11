import java.io.*;
import java.util.*;

//the Card class accepts the string from the scanner, and separates the values below into rank and suit.
class Card{
        private int rank;
        private char suit;
    Card(String card)
    {
        
//This section handles rank values that aren't numbers. I chose Ace to equal 1 instead of 14, and I will just account for the multiple values later on.
        if(card.charAt(0) == 'T') {
            this.rank = 10;
        } else if (card.charAt(0) == 'J') {
            this.rank = 11;
        } else if (card.charAt(0) == 'Q') {
            this.rank = 12;
        } else if (card.charAt(0) == 'K') {
            this.rank = 13;
        } else if (card.charAt(0) == 'A') {
            this.rank = 1;
        } else {
            
//This converts the characters to an integer.
            this.rank = Character.getNumericValue(card.charAt(0));
        }
        this.suit = card.charAt(1);
    }    
    
//These functions allowfor easy access to the rank and the suit.
        public int getRank(){
            return rank;
        }
    
        public char getSuit(){
            return suit;
        }
    }

//The Hand class takes an array of five Cards, and then figures out the best hand.
class Hand{
    
//cards is the array of five cards
    private Card[] cards;
    
//ranks is an array of all of the ranks. This gets sorted down below to check for sequencing. 
    private int[] ranks = new int[5];
    
//sameRank is a counter for how many times the same rank appears in the stack. This allows me to check for a pair, two pair, three of a kind, four of a kind, and full house with this variable.
    private int sameRank = 0;
    
//sameSuit is true if all cards are in the same suit, otherwise it is false.
    private boolean sameSuit = false;
    
//inSequence is a counter for how many cards in the hand are in sequence.
    private int inSequence = 0;
    
//royalFlush just checks to see if ranks[0] = 1 and if ranks[1] = 10. Since ranks is sorted from lowest to highest, if 
//those two values are in the first and second slot, that means that the hand has the required ranks to be a Royal Flush.
//However, we still have to check if the hand has the same suit.
    private boolean royalFlush = false;
    
    Hand(Card[] cards)
    {
        this.cards = cards;
        
//This section is a very roundabout way to check which ranks are equal. I was playing around with different ways to get
//the information accurately. However, I decided to go with this way since having sameRank at different values allowed me
//to check for pair, two pair, three of a kind, four of a kind, and full house with one variable.
        if(cards[0].getRank() == cards[1].getRank()){
            sameRank ++;
        }
        if(cards[0].getRank() == cards[2].getRank()){
            sameRank ++;
        }
        if(cards[0].getRank() == cards[3].getRank()){
            sameRank ++;
        }
        if(cards[0].getRank() == cards[4].getRank()){
            sameRank ++;
        }
        if (cards[1].getRank() == cards[2].getRank()){
            sameRank ++;
        }
        if (cards[1].getRank() == cards[3].getRank()){
            sameRank ++;
        }
        if (cards[1].getRank() == cards[4].getRank()){
            sameRank ++;
        }
        if (cards[2].getRank() == cards[3].getRank()){
            sameRank ++;
        }
        if (cards[2].getRank() == cards[4].getRank()){
            sameRank ++;
        }
        if (cards[3].getRank() == cards[4].getRank()){
            sameRank ++;
        }
        
//This if statement determines if all of the cards have the same suit. You only need to know if all of the cards are the same suit,
//which is why this is boolean.
        if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit()){
            sameSuit = true;
        }
        
//This loop creates the ranks array
        for(int i=0; i<=4; i++){
            ranks[i] = cards[i].getRank();
        }
        
//And this line sorts ranks from least to greatest.
        Arrays.sort(ranks);
        
//This loop and if statement determine if the ranks are in sequence. If all cards are in sequence, than inSequence should
//equal 4. I account for Aces being high by adding in 'or the first rank equals 1'. This way, [1, 2, 3, 4, 5] passes, as
//well as [1, 10, 11, 12, 13].
        for(int i=0; i<=3; i++){
            if(ranks[i+1] == ranks[i]+1 || ranks[i] == 1){
                inSequence++;
            }
        }
//This if statement checks if the first value of ranks is 1 and the second value is 10. Since ranks is sorted, these two  
//values will prove that you have the required ranks for a Royal Flush. Below, we also check for being in the same Suit
//and being in sequence. 
        if(ranks[0] == 1 && ranks[1] == 10){
            royalFlush = true;
        }
    }
//The coup de grâce. This checks for what kind of hand you have in order of importance, so you get the highest possible
//hand. If you have no possile hands, it returns high card.
    public String handRank(){
        if(royalFlush && inSequence == 4 && sameSuit){
            return "royal flush";
        } else if(sameSuit && inSequence == 4){
            return "straight flush";
        } else if(sameRank == 6){
            return "four of a kind";
        } else if(sameRank == 4){
            return "full house";
        } else if (sameSuit){
             return "flush";
        } else if (inSequence == 4){
             return "straight";    
        } else if (sameRank == 3){
             return "three of a kind"; 
        } else if (sameRank == 2){
             return "two pair"; 
        } else if (sameRank == 1){
             return "pair"; 
        } else {
             return "high card";     
        }
    }
}


//Solution accepts the input, and prints the best hand.
public class Solution {
    public static String main(String[] args) {
                
//cardArray is an array of all of our cards.
        Card[] cardArray = new Card[5];
        
//This loop makes all of those cards and adds them to the cardArray.
        for(int i=0; i <= 4; i++){
            String newCard = args[i];
            cardArray[i] = new Card(newCard);
        }
//h is our hand. We get to call our handRank method with returns the best hand. and Voila! We did it!
        Hand h = new Hand(cardArray);
        System.out.println(h.handRank());
		return (h.handRank());
    }
}
