##

### 📁 domain

#### 1. VisitDate

- 방문 날짜에 대한 유효성 검증
    - ✅ 방문 날이 1이상 31일 이하인지 검증
- ✅ 이벤트 날짜인지 확인
- ✅ 평일인지 주말인지 확인
- ✅ 별이 달린 날짜인지 확인

#### 2. Menu

- 메뉴 단일에 대한 정보를 담당하는 클래스

#### 3. Menus

- 총 메뉴에 대한 정보를 담당하는 클래스
- ✅ 메뉴 파일을 읽어서 List<Menu>객체로 변환
- ✅ 입력 받은 메뉴가 존재하는지 확인

#### 4. OrderMenu

- 주문한 메뉴에 대한 정보를 담당하는 클래스
- `Menu`를 필드로 사용

#### 5. OrderCount

- 주문한 메뉴의 갯수에 대한 클래스
    - ✅ 주문 갯수가 1개 이상인지 확인

#### 6. OrderMenus

- 총 주문한 메뉴에 대한 정보를 담당하는 클래스
    - ✅ 음료만 주문하였는지 확인
    - ✅ 총 주문량이 20이하인지 확인
    - ✅ 동일한 메뉴 주문에 대한 오류 처리

#### 7. EventBenefit

- 이벤트 혜택을 담당하는 클래스
- ✅ 총 주문 금액이 10000원 이상이면 혜택 계산
- ✅ 입력 받은 날짜의 평일/주말 혜택 계산
- ✅ 총 혜택 금액에 따른 이벤트 뱃지 구하기
- ✅ 증정 메뉴를 받는지 확인

#### 🗂️ enums

1. MenuType
    - 메뉴 타입을 열거형으로 관리
2. EventConstants
    - 이벤트에 대한 상수값을 관리
3. EventDayOfWeeks
    - 이벤트 요일의 주중/주말을 구분하여 관리
    - ✅ 매개변수로 들어온 날짜가 주말인지 확인
4. EventBedge
    - 이벤트 벳지에 대한 정보를 관리
    - ✅ 매개변수로 들어온 금액에 따른 뱃지 return
5. BenefitType
    - 이벤트 혜택에 대한 정보 관리
6. ErrorMessage
    - 에러 메세지에 대한 문자열 관리

<hr/>

### 📁 controller

#### 1. EventController

- 이벤트에 대한 컨트롤러

<hr/>

### 📁 util

#### 1. Parse

#### 2. Validator

- 공통된 유효성 검증을 관리하는 클래스

#### 3. ErrorException

- 커스텀 Exception을 관리하는 클래스

#### 4. ResourceReader

- 파일을 읽어주는 클래스

<hr/>

### 📁 view

#### ⤵️ InputView.class

- 입력을 담당하는 클래스
- 방문 날짜를 입력받음
- 주문 메뉴를 입력받음

#### ⤴️ OutputView.class

- 출력을 담당하는 클래스
- 주문 받은 내용을 토대로 혜택을 출력