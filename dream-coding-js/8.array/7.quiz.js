// 퀴즈1: 주어진 배열 안의 딸기 아이템을 키위로 교체하는 함수를 만들기
// 단, 주어진 배열을 수정하지 않도록!
// input: ['🍌', '🍓', '🍇', '🍓']
// output: [ '🍌', '🥝', '🍇', '🥝' ]

const array1 = ['🍌', '🍓', '🍇', '🍓'];
const result1 = array1.map((item) => {
  if (item === '🍓') {
    return item = '🥝';
  } else {
    return item;
  }
} );
console.log(result1);

// ellie's solution

// function replace(array, from, to) {
//   return array.map((item) => item === from ? to : item)
// }
// console.log(replace(array1, '🍓', '🥝'));

//-------------------------------------------------------------
// 퀴즈2:
// 배열과 특정한 요소를 전달받아,
// 배열안에 그 요소가 몇개나 있는지 카운트 하는 함수 만들기
// input: [ '🍌', '🥝', '🍇', '🥝' ], '🥝'
// output: 2

function count ( array, value) {
  return array.filter((item) => item === value ).length;
}
console.log(count([ '🍌', '🥝', '🍇', '🥝' ], '🥝')); 

//reduce 사용

// function count (array, item) {
//   return array.reduce((sum, value) => {
//     if (value === item) {
//       sum++;
//     }
//     return sum;
//   },0)
// };
// console.log(count([ '🍌', '🥝', '🍇', '🥝' ], '🥝'));

//--------------------------------------------------------------
// 퀴즈3: 배열1, 배열2 두개의 배열을 전달받아,
// 배열1 아이템중 배열2에 존재하는 아이템만 담고 있는 배열 반환
// input: ['🍌', '🥝', '🍇'],  ['🍌', '🍓', '🍇', '🍓']
// output: [ '🍌', '🍇' ]

function match (input, search) {
  return input.filter((item) => search.includes(item));
}
console.log(match(['🍌', '🥝', '🍇'], ['🍌', '🍓', '🍇', '🍓']));

//---------------------------------------------------------------------
// 퀴즈4: 5이상의 숫자들의 평균

const nums = [3, 16, 5, 25, 4, 34, 21];

const result2 = nums 
.filter((num) => num >= 5)   // [16, 5, 25, 34, 21]
.reduce((avg, num, _, array) => avg + num / array.length, 0); //고차함수는 배열 그 자체를 받아 올 수 있음
console.log(result2); 