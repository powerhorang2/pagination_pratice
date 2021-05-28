package pagination;

public class PageMaker {
	private final static int DISPLAY_BLOCK_NUM = 5; // 페이지 블럭 개수
	private int startPage = 1; // 페이지 블럭에 출력 될 시작 페이지
	private int endPage; // 페이지 블럭에 출력 될 마지막 페이지
	private boolean prev; // 이전
	private boolean next; // 다음
	private Paging paging;
	
	public void setPaging(Paging paging) {
		this.paging = paging;
		calcData();
	}
	
	private void calcData() {
		this.startPage = ((paging.getNowPage() / DISPLAY_BLOCK_NUM) - (paging.getNowPage() % DISPLAY_BLOCK_NUM == 0 ? 1 : 0)) * DISPLAY_BLOCK_NUM + 1;
		this.endPage = this.startPage + DISPLAY_BLOCK_NUM - 1;
		
		if(this.endPage > paging.getTotalPage()) {
			this.endPage = paging.getTotalPage();
		}
		
		// 이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true ( 시작페이지가 1 아니면 생김 )
		prev = startPage == 1 ? false : true;
		// 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 개수 < 총 게시글의 개수 ? true : false
		next = endPage * paging.getPageSize() < paging.getTotalArticle() ? true : false;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean getPrev() {
		return prev;
	}

	public boolean getNext() {
		return next;
	}
	
}
