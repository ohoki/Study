//논리연산자 Logical Operators
//&& 그리고
//|| 또는
//! 부정
//!! 불리언값으로 변환

let num = 8;
if (num >= 0 && num < 9) {
  console.log('ㅎㅎ');
}

if (!(num >= 0 || num > 20)) {
  console.log('ㅎㅎ');
}  

if (num != 8) {
  console.log('ㅎㅎ');
}

console.log( true && true); //true  
console.log( true && false); //false
console.log( false && true); //false
console.log( false && false); //false

console.log( true || true); //true
console.log( true || false); //true
console.log( false || true); //true
console.log( false || false); //false

console.log(!'text'); //faluse (text는 true 값을 가진다)
console.log(!!'text'); //true