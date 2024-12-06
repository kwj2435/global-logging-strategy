## Logging, Exception 처리 전략 정리 및 샘플 코드

---
### Logging 처리 전략
**첫째,** 반드시 필요한 로그만 남긴다.  

**둘째,** 사용자의 요청과 요청에 따른 응답을 명확히 확인할 수 있어야 한다.  

**셋째,** 사용자의 요청에 따른 로직의 흐름을 Tracking 할수 있어야 한다.  

**Logging 처리 전략에 따른 구현 요구 사항**

### Exception 처리 전략
**첫째,** 예외를 로깅해야 한다.
예외가 발생했을 때 로그를 남기면 문제의 원인을 파악하고 해결하는데 도움이 된다.

**둘째,** 커스텀 예외 클래스를 사용한다.
비즈니스 로직에 맞는 커스텀 예외를 작성하면 예외의 의미를 명확히 할 수 있다.

**셋째,** 애플리케이션 전역에서 예외를 처리할 수 있도록 @ControllerAdvice와 @ExceptionHandler를 활용한다.

**넷째,** 예외 발생 시 적절한 수준(ERROR, WARN, INFO)으로 로깅하여 문제를 추적 가능하게 한다.

다섯째, 예외 발생 상황에 대한 모니터링과 알림 설정을 한다.

**여섯째,** 예외 처리시 불필요한 try-catch를 줄이고, 가능한 한 높은 계층에서 Exception을 처리한다.
더불어 적절한 HTTP 상태 코드를 반환하여 클라이언트가 응답을 이해할 수 있게 한다.
또한 민감한 정보(예: 비밀번호, API 키)는 예외 메시지에 포함하지 않는다.

**Excpetion 처리 전략에 따른 구현 요구사항**
