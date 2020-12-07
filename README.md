# TEST of Masters Course 

## Step-1 _ 단어 밀어내기 구현하기

### 구현목록

1. 공백을 기준으로 사용자로부터 단어 하나, 정수 숫자 하나 (-100 <= N < 100), L 또는 R을 입력받는다.   
    (L 또는 R은 대소문자 모두 입력 가능하다. 입력을 요청할 때는 `>` 표시로 입력이 필요함을 나타낸다.)    
    입력예시 : `apple 3 L `   
2. 아래 조건대로 단어를 밀어낸다.
    - L인 경우, 주어진 숫자 갯수만큼 왼쪽으로 밀어낸다.
    - R인 경우, 주어진 숫자 갯수만큼 오른쪽으로 밀어낸다.
    - 숫자가 음수인 경우, 해당 절대값 크기만큼 반대쪽으로 밀어낸다.
    - 숫자가 글자의 갯수를 초과하는 경우, 글자의 첫번째 자리로 돌아와 이어서 카운팅 한다.
3. 밀려나간 단어는 반대쪽으로 채워진다.
4. 홀수줄은 입력, 짝수줄은 출력이며 1~3의 과정을 반복한다.
5. `q`를 입력하면 프로그램을 종료시킨다.

### 출력예시
```
> apple 3 L 
leapp

> banana 6 R
banana

> carrot -1 r
arrotc

> cat -4 R
atc
```
### 요구사항

- 컴파일 되어야 한다.
- 최대한 간결하게 코드를 작성한다.