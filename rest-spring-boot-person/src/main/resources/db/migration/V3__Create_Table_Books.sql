CREATE TABLE IF NOT EXISTS public.books (
  id SERIAL PRIMARY KEY,
  author TEXT,
  launch_date timestamp(6) NOT NULL,
  price decimal(65,2) NOT NULL,
  title TEXT
)
