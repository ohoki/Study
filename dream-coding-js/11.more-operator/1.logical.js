//논리연산자 Logical Operator
//&& 그리고
//|| 또는
//단축평가: short-circuit evaluation
const obj1 = { name: '🐶'};
const obj2 = { name: '🐺', owner: 'Youngho'};

if( obj1 && obj2) {
  console.log('둘다 true!');
}

let result = obj1 && obj2;
console.log(result); //{ name: '🐺', owner: 'Youngho' }
// obj1이 true이기 때문에 obj2가 true인지 false인지 평가 할 필요가 없다
// 이걸 단축평가라고 하며 남은 obj2가 result에 할당된다.
// 조건문 안에서는 다 평가함

result = obj1 || obj2;
console.log(result); //{ name: '🐶' }
//obj1이 할당됨


// 활용예제
//&& 조건이 truthy일때, 무언가를 해야 할 경우
//|| 조건이 falshy일때, 무언가를 해야 할 경우
function changeOwner(animal) {
  if(!animal.owner) {
    // undefined는 false, !undefined는 true
    throw new Error("주인이 없어");
  }
  animal.owner = '바뀐 주인!';
};
function makeOwner(animal) {
  if(animal.owner) {
    throw new Error("주인이 있어");
  }
  animal.owner = '새로운 주인!';
};

obj1.owner && changeOwner(obj1);
obj2.owner && changeOwner(obj2);
console.log(obj1);
console.log(obj2);

obj1.owner || makeOwner(obj1);
obj2.owner || makeOwner(obj2);
console.log(obj1);
console.log(obj2);

// null 또는 undefined인 경우를 확인할 때
let item; // ={ price: 1};
const price = item && item.price;
console.log(price);

//기본값을 설정
//default parameter은 전달하지 않거나, undefined인 경우에만 설정 됨
// || 값이 falshy한 경우 설정 됨: 0, -0, null, undefined, '' 
function print(message) {
  const text = message || 'Hello';
  console.log(message);
};
print();
