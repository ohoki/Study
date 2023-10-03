//퀴즈!!

let num = 2;
// num의 숫자가 짝수이면 👍, 홀수라면 👎을 출력하도록
//if
//ternary
//두가지 방법으로 구현해보기

if (num % 2 === 0) {
  console.log('👍');
} else {
  console.log('👎');
}

num % 2 === 0 ? console.log('👍') : console.log('👎');

let emoji = num % 2 === 0 ? '👍' : '👎'; //표현식은 값으로 나타낼 수 있다.
console.log(emoji);