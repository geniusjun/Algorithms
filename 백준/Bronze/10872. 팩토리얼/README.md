# [Bronze III] 팩토리얼 - 10872 

[문제 링크](https://www.acmicpc.net/problem/10872) 

### 깨달은 점
팩토리얼은 이런 느낌으로 짜야한다는 걸 깨닫고, 곱셈일 때는 += 말고 *=도 써보자. 아니면 매서드를 따로 빼서 
public static int factorial(int n) {
        if (n == 0) return 1;  // 0! = 1
        return n * factorial(n - 1);  // n! = n * (n-1)!
    } 이런 느낌으로 팩토리얼의 수학적 정의 접근과 재귀함수를 이용하여 깔끔하게 정의 후 편하게 이용하는 방법도 좋은 것 같다.
    팩토리얼은 재귀함수의 유명한.. 놈이니 꼭 기억하자.

### 성능 요약

메모리: 17628 KB, 시간: 164 ms

### 분류

구현, 수학

### 제출 일자

2024년 10월 8일 20:41:32

### 문제 설명

<p>0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.</p>

### 출력 

 <p>첫째 줄에 N!을 출력한다.</p>

