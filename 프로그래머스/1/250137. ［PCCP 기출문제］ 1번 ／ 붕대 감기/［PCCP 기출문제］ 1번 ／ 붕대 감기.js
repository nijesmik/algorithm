function solution(bandage, health, attacks) {
    const [castTime, heal, bonus] = bandage;
    let hp = health;
    let currentTime = 0;
    
    for (let attack of attacks) {
        const [attackTime, damage] = attack;
        const time = attackTime - currentTime - 1;
        const totalHeal = time * heal + Math.floor(time / castTime) * bonus;
        hp = Math.min(health, hp + totalHeal) - damage;
        if (hp <= 0) {
            return -1;
        }
        currentTime = attackTime;
    }

    return hp;
}