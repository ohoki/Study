//Iterable 하다는 건! 순회가 가능하다는 것!
//객체 안에서 [Symbol.iterator](): Iterator; 를 반환해야함
//심볼정의를 가진 객체나, 특정한 함수가 Iterator를 리턴한다는 것은
//순회가 가능한 객체이다 라는 걸 알 수 있음
//순회가 가능하면 무엇을 할 수 있나? -> for..of, spread 를 사용 가능

const array = [1, 2, 3]
for (const item of array) {
  console.log(item);
} 
//iterableIterator가 필요하다!!

const iterator = array.values();
// for (const item of iterator) {
//   console.log(item);
// } 
// console.log(iterator.next()); //{ value: 1, done: false } done은 마지막 인지 아닌지 표시
// console.log(iterator.next().value);
// console.log(iterator.next().value);
// console.log(iterator.next().done);
while(true) {
  const item = iterator.next();
  if (item.done) break;
  console.log(item.value);
}
