function solution(coin, cards) {
    const n = cards.length + 1;
    let index = Math.round(cards.length / 3);
    const deck = new Set(cards.slice(0, index));
    const temp = new Set();
    
    const getPairCard = (cardSet) => {
        for (card of cardSet) {
            if (cardSet.has(n - card)) {
                return card;
            }
        }
        return 0;
    }
    
    const buyCard = (card) => {
        if (deck.has(n - card) && coin > 0) {
            deck.add(card);
            coin--;
        } else {
            temp.add(card);
        }
    }
    
    let round = 1;
    while (index < n - 1) {
        const pick1 = cards[index];
        const pick2 = cards[index + 1];
        index += 2;
        
        buyCard(pick1);
        buyCard(pick2);
        
        const card = getPairCard(deck);
        const tempCard = getPairCard(temp);
        
        if (card > 0) {
            deck.delete(card);
            deck.delete(n - card);
            round++;
        } else if (coin >= 2 && tempCard > 0) {
            temp.delete(tempCard);
            temp.delete(n - tempCard);
            coin -= 2;
            round++;
        } else {
            return round;
        }
    }
    
    return round;
}