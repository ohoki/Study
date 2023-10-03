{
  const x = 1;
{
  const y = 2;
  console.log(x);
}
  console.log(x);
  // console.log(y); 
}
//expected error!!(외부에서 내부의 변수를 참조할 수 없다!! 그래서 y에서 error!!)

const text = 'global'; // 전역 변수, 전역 스코프 (글로벌 변수, 글로벌 스코프)
{
  const text = 'inside block1'; //지역 변수(로컬변수), 지역 스코피(로컬스코프)
  {
    console.log(text);
  }
};
//expected inside block1 (상위의 변수에 접근할 수 있다.)
