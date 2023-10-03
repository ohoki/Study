// 배열의 함수들
// 배열 자체를 변경하는지, 새로운 배열을 반환하는지 부분을 포인트로 봐야함

const fruits = ['🍌', '🍎', '🍊'];

// 특정한 오브젝트가 배열인지 아닌지 체크
console.log(Array.isArray(fruits));
console.log(Array.isArray({}));

// 특정한 아이템의 위치를 찾을때
console.log(fruits.indexOf('🍎'));

// 배열안에 특정한 아이템이 있는지 없는지 확인
console.log(fruits.includes('🍌'));

// 추가 - 제일 뒤
fruits.push('🥑'); // 배열 자체를 수정(업데이트)
console.log(fruits);
// 추가 - 제일 앞
fruits.unshift('🍉'); // 배열 자체를 수정
console.log(fruits);

// 제거 - 제일 뒤
fruits.pop(); // 배열 자체를 수정
console.log(fruits);

// 제거 - 제일 앞
fruits.shift(); // 배열 자체를 수정
console.log(fruits);

// 중간에 추가 또는 삭제
fruits.splice(1, 1); //배열 자체를 수정
console.log(fruits); 
fruits.splice(1, 0, '🍎', '🍉');
console.log(fruits); 

// 잘라진 새로운 배열을 만듬
let newArr = fruits.slice(0, 2); //0, 1 의 아이템으로 새로운 배열 생성
console.log(newArr);             //-num 은 뒤에서부터 슬라이스
console.log(fruits);

//여러개의 배열을 붙여줌
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const arr3 = arr1.concat(arr2); //새로운 배열을 반환
console.log(arr1);
console.log(arr2);
console.log(arr3);

// 순서를 거꾸로
const arr4 = arr3.reverse();
console.log(arr4);

console.clear();

// 중첩 배열을 하나의 배열로 쫙 펴기
let arr = [
  [1, 2, 3],
  [4, [5, 6]],
];
console.log(arr);
console.log(arr.flat()); //새로운 배열 반환 (한단계 까지만 플랫해줌)
console.log(arr.flat(2)); // 플랫해줄 단계를 설정해주면 됨

arr = arr.flat(2);

// 특정한 값으로 배열을 채우기
arr.fill(0); //배열 자체를 수정
console.log(arr);

arr.fill('s', 1, 3);
console.log(arr);

arr.fill('s', 1);
console.log(arr);

//배열을 문자열로 합하기
let text = arr.join();
console.log(text); //0,s,s,s,s,s

text = arr.join(' ! '); //, 대신 다른걸로 바꿀 수도 있음
console.log(text); 



