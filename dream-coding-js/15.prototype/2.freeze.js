// 동결! Object.freeze - 프로퍼티 추가, 삭제, 쓰기, 속성 재정의 불가!!
// (단, 얕은 꽁꽁 얼림이 된다!)
const youngho = { name: '영호'};
const dog = { name: '와우', emoji: '🐶', owner: youngho };
Object.freeze(dog);
dog.name = '멍멍';
console.log(dog); // name이 변경되지 않음 
youngho.name = '엘리얌';
console.log(dog); // 얕은 꽁꽁 얼림이라서 owner의 이름은 변경됨을 확인 할 수 있다
//{ name: '와우', emoji: '🐶', owner: { name: '엘리얌' } }

// 밀봉! Object.seal - 값의 수정은 가능/ 추가, 삭제, 속성 재정의 불가!!
const cat = {};
Object.assign(cat, dog); //dog의 속성을 cat에 복사
Object.seal(cat);
cat.name = '야옹';
console.log(cat);

console.log(Object.isFrozen(dog));
console.log(Object.isSealed(cat));

// 확장 금지 preventExtentions - 추가만 안됨!!
const  tiger = { name: '어흥'};
Object.preventExtensions(tiger);
console.log(Object.isExtensible(tiger)); //false
tiger.name = '아흐흥';
console.log(tiger);
tiger.age = 10;
console.log(tiger);