// 동등 비교 관계 연산자 (Equality Operators)

//== 값이 같음
//!= 값이 다름
//=== 값과 타입이 둘다 같음
//!== 값과 타입이 다름

console.log(2 == 2); //true
console.log(2 != 2); //false
console.log(2 != 3); //true
console.log(2 == 3); //false
console.log(2 == '2'); //true
console.log(2 === '2'); //false
console.log(true == 1); //true
console.log(true === 1); //false


const obj1 = {
  name: 'js',
};
const obj2 = {
  name: 'js',
};

console.log(obj1 == obj2); //false
// 메모리값(참조값)이 다르기 때문에 두 값은 다르다 => false

console.log(obj.name == obj2.name); //true
console.log(obj.name === obj2.name);  //true
// Heap에 저장된 name 값은 같기 때문에 두 값은 같다 => true

let obj3 = obj2;
console.log(obj3 == obj2); //true
console.log(obj3 === obj2); //true
// 메모리에 저장된 참조값이 같기 때문에 두 값은 같다 => true