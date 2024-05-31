# Document Management Program (이하 Document manangement app for Android 7.0x or higher)

![Logo](추후 업로드 예정)

Document Management Program은 안드로이드 플랫폼에서 문서를 관리하고 저장하는 애플리케이션입니다. 
이 앱은 사용자가 문서를 추가, 편집, 삭제하고 저장된 문서 목록을 편리하게 관리할 수 있도록 지원합니다.

## Installation

1. 이 저장소를 클론합니다.

    ```bash
    git clone https://github.com/your_username/document-management-program.git
    ```

2. Android Studio를 열고 프로젝트를 로드합니다.

3. 앱을 빌드하고 실행합니다.

## 프로젝트 구조

- **MainActivity**: 앱의 메인 화면으로, 저장된 문서 목록을 표시하고 문서를 추가, 편집, 삭제할 수 있는 기능을 제공합니다.
- **AddEditDocumentActivity**: 새 문서를 추가하거나 기존 문서를 편집하는 화면입니다.
- **DocumentAdapter**: RecyclerView에 연결되어 저장된 문서 목록을 표시하는 어댑터 클래스입니다.
- **DocumentViewModel**: 앱의 데이터를 관리하고 뷰와 데이터 간의 통신을 처리하는 ViewModel 클래스입니다.
- **DocumentRepository**: 데이터베이스와 ViewModel 간의 중개 역할을 담당하는 Repository 클래스입니다.
- **DocumentDatabase**: Room 라이브러리를 사용하여 SQLite 데이터베이스를 생성하고 관리하는 클래스입니다.
- **DocumentDao**: 데이터베이스 액세스를 위한 Data Access Object 인터페이스입니다.
- **SwipeToDeleteCallback**: RecyclerView의 아이템을 스와이프하여 삭제할 수 있도록 도와주는 콜백 클래스입니다.

## 사용 예시

![Screenshot](추후 업로드 예정)

## 라이선스

이 프로젝트는 MIT 라이선스에 따라 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하십시오.

## 기여

이 프로젝트에 기여하려면 다음 단계를 따르십시오:

1. 이 저장소를 포크합니다.
2. 새로운 기능이나 버그 수정에 대한 브랜치를 생성합니다. (`git checkout -b feature/new-feature`)
3. 변경 사항을 커밋하고 (`git commit -am 'Add new feature'`) 저장소로 푸시합니다. (`git push origin feature/new-feature`)
4. 포크한 저장소로부터 Pull Request를 생성합니다.

## 문제 해결

문제 해결을 위한 자주 묻는 질문을 보려면 [FAQ](FAQ.md) 파일을 확인하십시오.

## 연락처

추가 질문이나 피드백이 있으시면 이메일을 보내주시기 바랍니다: 2020E7427@gs.anyang.ac.kr

---
