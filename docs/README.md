##

### 📁 domain

#### 1. VisitDate
- 방문 날짜에 대한 유효성 검증 
  - 방문 날이 1이상 31일 이하인지 검증
- 이벤트 날짜인지 확인
- 평일인지 주말인지 확인
- 별이 달린 날짜인지 확인
#### 2. Menu
- 메뉴 단일에 대한 정보를 담당하는 클래스
#### 3. Menus
- 총 메뉴에 대한 정보를 담당하는 클래스
#### 4. OrderMenu
- 주문한 메뉴에 대한 정보를 담당하는 클래스
- `Menu`를 상속받아서 사용
#### 5. OrderMenus
- 총 주문한 메뉴에 대한 정보를 담당하는 클래스
#### 🗂️ enums
1. MenuType
    - 메뉴 타입을 열거형으로 관리
2. EventConstants
   - 이벤트에 대한 상수값을 관리
3. EventDayOfWeeks
   - 이벤트 요일의 주중/주말을 구분하여 관리
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

<hr/>

### 📁 view
#### ⤵️ InputView.class
- 입력을 담당하는 클래스
- 방문 날짜를 입력받음
- 주문 메뉴를 입력받음
#### ⤴️ OutputView.class
- 출력을 담당하는 클래스
- 주문 받은 내용을 토대로 혜택을 출력