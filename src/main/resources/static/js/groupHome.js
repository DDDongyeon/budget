        // 검색된 그룹 보여주는 페이지로 이동하기
        function goToSearchPage(searchInput) {
            var searchTmp = document.getElementById(searchInput);
            var searchValue = searchTmp.value;

            location.href = "/group/search?q=" + searchValue;
        }

        // 그룹 만들기 페이지로 이동
        function goToGroupCreationPage() {
            location.href = "/group/create";
        }

        // 그룹의 피드로 이동
        function goToGroupFeed(gNo) {
            location.href = "/group/feed?groupNo=" + gNo;
        }

        // 태그로 그룹 조회해서 그룹 메인 보여주기
        function showGroupsByTag(tag) {
        	document.querySelector('.tag1').classList.remove('selected');
      	  document.querySelector('.tag2').classList.remove('selected');
      	  document.querySelector('.tag3').classList.remove('selected');
      	  document.querySelector('.tag4').classList.remove('selected');

      	  if (tag === '청소년') {
      	    document.querySelector('.tag1').classList.add('selected');
      	  } else if (tag === '대학생') {
      	    document.querySelector('.tag2').classList.add('selected');
      	  } else if (tag === '취준생') {
      	    document.querySelector('.tag3').classList.add('selected');
      	  } else if (tag === '직장인') {
      	    document.querySelector('.tag4').classList.add('selected');
      	  }
            location.href = "/group/list?tag=" + tag;
        }

        // 모달 열기
        function openModal(groupNo) {
            var modal = document.getElementById("groupModal");
            modal.style.display = "block";

            // 그룹 정보를 가져와서 모달에 표시하는 AJAX 요청
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var groupInfo = document.getElementById("groupInfo");
                    groupInfo.innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "/group/info?groupNo=" + groupNo, true);
            xhttp.send();
        }

        // 모달 닫기
        function closeModal() {
            var modal = document.getElementById("groupModal");
            modal.style.display = "none";
        }

        // 그룹 가입하기
        function groupJoin(gNo) {
            var groupNo = gNo;
            var form = document.createElement("form");
            form.method = "POST";
            form.action = "/group/join";

            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "groupNo";
            input.value = groupNo;
            form.appendChild(input);

            document.body.appendChild(form);
            form.submit();
        }