SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.published_date, '%Y-%m-%d') AS PUBLISHED_DATE FROM book b
  JOIN author a ON b.author_id = a.author_id
  WHERE b.category = '경제'
  ORDER BY b.published_date ASC;