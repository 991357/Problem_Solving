public class BookTest
{
    public static void main(String[] args)
    {
        BookManagerImpl ibm = new BookManagerImpl();

        ibm.books = new Book[10];

        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        ibm.add(b1);

        Book b2 = new Book("21424", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
        ibm.add(b2);

        Book b3 = new Book("35355", "분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링");
        ibm.add(b3);

        Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jean.kr", 10000, "1월 알고리즘", 2021, 1);
        ibm.add(m1);

        StringBuilder sb = new StringBuilder();

        sb.append("***************도서 전체 목록***************\n");
        for (Book b : ibm.getList())
        {
            if (b != null)
                sb.append(b).append("\n");
        }
        sb.append("***************일반 전체 목록***************\n");
        for (Book b : ibm.getBooks())
        {
            if (b != null)
                sb.append(b).append("\n");
        }
        sb.append("***************잡지 목록***************\n");
        for (Magazine m : ibm.getMagazines())
        {
            if (m != null)
                sb.append(m).append("\n");
        }
        sb.append("***************도서 제목 포함검색:Java***************\n");
        for (Book m : ibm.searchByTitle("Java"))
        {
            if (m != null)
                sb.append(m).append("\n");
        }
        sb.append("도서 가격 총합 : ").append(ibm.getTotalPrice()).append("\n");
        sb.append("도서 가격 평균 : ").append(ibm.getPriceAvg()).append("\n");

        System.out.println(sb);
    }
}
