//고차 함수 (higher order function)

const fruits = ['🍌', '🍓', '🍇', '🍓'];

// for (let i = 0; i < fruits.length; i++) {
//   console.log(fruits[i]);
//   }

// 배열을 빙글 빙글 돌면서 원하는 것(콜백함수)을 할 때 - 고차함수
// forEach(function(value, index, array){}); - 필요없는 변수는 생략 가능
fruits.forEach(function(value) {
  console.log(value);
});

fruits.forEach((value) => console.log(value)); //화살함수로 생략 가능

//조건에 맞는(콜백함수) 아이템을 찾을 때 
//find: 제일 먼저 조건에 맞는 아이템을 반환
//findIndex: 제일 먼저 조건에 맞는 아이템의 인덱스를 반환
const item1 = { name: '🍕', price: 3 };
const item2 = { name: '🍜', price: 1 };
const item3 = { name: '🍣', price: 2 };
const products = [item1, item2, item3, item2];
let found = products.find((value) => value.name === '🍜');
console.log(found);

found = products.findIndex((value) => value.name === '🍜');
console.log(found);

// 배열의 아이템들이 부분적으로 조건(콜백함수)에 맞는지 확인
let result = products.some((value) => value.name === '🍜');
console.log(result); //true

// 배열의 아이템들이 전부 조건(콜백함수)에 맞는지 확인
result = products.every((value) => value.name === '🍜');
console.log(result); //false

// 조건에 맞는 모든 아이템들을 새로운 배열로!
result = products.filter((value) => value.name === '🍜');
console.log(result); //[ { name: '🍜', price: 1 }, { name: '🍜', price: 1 } ]

// Map - 배열의 아이템들을 각각 다른 아이템으로 매핑할 수 있는, 변환해서 새로운 배열 생성!

const nums = [1, 2, 3, 4, 5];
result = nums.map((item) => item *2);
console.log(result);

result = nums.map((item) => {
  if (item % 2 === 0) {
    return item * 2;
  } else {
    return item ;
  }
})
console.log(result);

//flatMap - 중첩된 배열을 쫘악 펴줌
result = nums.map((item) => [1,2]); 
console.log(result);
//[ [ 1, 2 ], [ 1, 2 ], [ 1, 2 ], [ 1, 2 ], [ 1, 2 ] ]

result = nums.flatMap((item) => [1,2]);
console.log(result);
//[1, 2, 1, 2, 1,2, 1, 2, 1, 2]

result = ['dream', 'coding'].map((text) => text.split(''));
console.log(result);
//[ [ 'd', 'r', 'e', 'a', 'm' ], [ 'c', 'o', 'd', 'i', 'n', 'g' ] ]

result =  ['dream', 'coding'].flatMap((text) => text.split(''));
console.log(result);
//['d', 'r', 'e', 'a','m', 'c', 'o', 'd','i', 'n', 'g']

// sort 배열의 아이템들을 정렬함
// "문자열" 형태의 오름차순으로 요소를 정렬하고, 기존의 배열을 변경
const texts = ['hi', 'abc'];
texts.sort();
console.log(texts); //[ 'abc', 'hi' ]

const numbers = [0, 5, 4, 2, 1, 10];
numbers.sort();
console.log(numbers); //[ 0, 1, 10, 2, 4, 5 ]
//문자열 기준으로 정렬하기 때문에 숫자의 경우 정렬이 제대로 되지 않음
//그래서 sort함수에 콜백함수를 불러와야한다

numbers.sort((a, b) => a-b); 
// a, b 값들을 하나씩 비교하면서 대소 관계를 구별함
// < 0 -> a < b - a가 앞으로 정렬
// > 0 -> a > b - b가 앞으로 정렬
console.log(numbers); //[ 0, 1, 2, 4, 5, 10 ]

// reduce 배열의 값을 접어서 접어서 하나로
result = [1, 2, 3, 4, 5].reduce((sum, value) => (sum += value), 0);
// sum의 값은 0(reduce의 인자)로 설정되고 배열 안의 값들이 하나씩 더해지는 구조
console.log(result); //15 <- 데이터가 값으로 나온다

