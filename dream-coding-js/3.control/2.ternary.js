//삼항 조건 연산자 Ternary Operators

//조건식 ? 참인 경우 : 거짓인 경우

let fruit = 'apple';
if (fruit === 'apple') {
  console.log('🍎');
} else {
  console.log('!!');
}

fruit === 'apple' ? console.log('🍎') : console.log('!!');

let emoji = fruit === 'apple' ? '🍎' : '!!'; //표현식은 값으로 나타낼 수 있다.

console.log(emoji);