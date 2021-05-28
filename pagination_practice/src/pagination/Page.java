package pagination;

public class Page {
	private int nowPage; // 현재 페이지 번호
	private int totalPage; // 총 페이지의 수
	private int pageSize = 10; // 페이지 하나당 출력되는 게시글의 수
	private int totalArticle; // 전체 게시글의 수
	private int startRow; // 현재 페이지에서 게시글 리스트의 첫번째 행
	private int endRow; // 현재 페이지에서 게시글 리스트의 마지막 행
	
	public Page() {
		super();
	}
	
	// 현재 페이지와 게시글의 총량을 가진 생성자.
	public Page(int nowPage, int totalArticle) {
		setNowPage(nowPage);
		setTotalArticle(totalArticle);
		setTotalPage();
		setStartRow();
		setEndRow();
	}
	
	// 기본 페이지 하나당 출력되는 게시글 수를 변경할 때 사용하는 현재 페이지와 게시글의 총량을 가진 생성자.
	public Page(int nowPage, int pageSize, int totalArticle) {
		setNowPage(nowPage);
		setPageSize(pageSize);
		setTotalArticle(totalArticle);
		setTotalPage();
		setStartRow();
		setEndRow();
	}
	
	// 페이지 번호 설정
	public void setNowPage(int nowPage) {
		// 페이지 번호가 없을 때 1로 맞춰줌
		if (nowPage <= 0) {
			this.pageSize = 1;
			return;
		}
		this.nowPage = nowPage;
	}
	
	// 페이지당 출력 게시글 수 설정
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	// 전체 게시글 갯수
	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}
	
	// 페이지 갯수
	public void setTotalPage() {
		this.totalPage = this.totalArticle / this.pageSize + (this.totalArticle % this.pageSize == 0 ? 0 : 1);
		
		//유효성 검사 (현재 페이지가 유효한지)
		if(this.nowPage <= 0 || this.nowPage > totalPage) {
			this.nowPage = 1;
		}
	}
	
	// 게시글 시작 행 설정
	public void setStartRow() {
		this.startRow = (this.nowPage - 1) * this.pageSize + 1;
	}
	
	// 게시글 끝 행 설정
	public void setEndRow() {
		this.endRow = nowPage * pageSize;
		if(endRow > this.totalArticle) endRow = this.totalArticle;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
}
