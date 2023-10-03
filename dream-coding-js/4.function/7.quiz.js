// 주어진 숫자 만큼 0부터 순회하는 함수
// 순회하면서 주어진 특정한 일을 수행해야 함
// 5. 순회하는 숫자를 다 출력하고 싶음
// 5. 순회하는 숫자의 두배값을 다 출력하고 싶음
// function iterate(max, action)

function iterate(max, action) {
    const result = action(max);
    console.log(result);
    return result;
}

function tour (max) {
  for (let i = 0; i < max; i++) {
    console.log(i);
  }
}

function tourAndDouble (max) {
  for (let i = 0; i < max; i++) {
    console.log(2 * i);
  }
}

iterate(5, tour);
iterate(5, tourAndDouble);

//--------------------엘리의 풀이--------------------------
// function iterate(max, action) {
//   for (let i = 0; i <max; i++) {
//     action (i);
//   }
// }

// function tour(num) {
//   console.log(num);
// }

// function tourAndDouble(num) {
//   console.log(2 * num);
// }

// iterate(5, tour);
// iterate(5, tourAndDouble);

//iterate(5, (i) => consol.log(num)); 함수를 바로 값으로 전달해줘도 됨!!
//iterate(5, (i) => consol.log(num * 2)); 함수를 바로 값으로 전달해줘도 됨!!


//setTimeout

// setTimeout(callback, 1000) {} //1000 === 1초 
setTimeout(() => {
  console.log('3초뒤 이 함수가 실행될거에요');
}, 3000);
//3초뒤에 내 콜백함수를 실행해줘