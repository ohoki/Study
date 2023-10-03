//객체 타입 (복합 데이터)
//원시 타입의 경우 메모리의 Data 나 Stack에 보관되지만 
//객체 타입의 경우 메모리의 Heap에 보관된다.


let name = 'apple';
let color = 'red';
let display = '🍎';

let apple = {
  name: 'apple',
  color: 'red',
  display: '🍎',
};

console.log(apple);
console.log(apple.name);
console.log(apple.color);
console.log(apple.display);
