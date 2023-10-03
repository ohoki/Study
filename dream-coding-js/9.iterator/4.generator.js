// const multiple = {
//   [Symbol.iterator]: () => {
//     const max = 10;
//     let num = 0;
//     return {
//       next() {
//         return { value: num++ * 2 , done: num >= max };
//       },
//     };
//   },
// };

function* multipleGenerator() {
  for (let i = 0; i < 10; i++) {
    console.log(i);
    yield i** 2;   
    //yield는 호출할 때 마다 값을 반환 (return은 한번에 모든 값 반환)
  }
}
const multiple = multipleGenerator();
let next = multiple.next();
console.log(next.value, next.done);
next = multiple.next();
console.log(next.value, next.done);



// multiple.return;
// multiple.throw('Error!');