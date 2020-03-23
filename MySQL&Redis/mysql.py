from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column,Integer, String, DateTime, Boolean

#('mysql://用户:密码@地址:端口/库名')
engine = create_engine('mysql://root:@localhost:3306/news')
Base = declarative_base()

class New(Base):
	__tablename__ = 'news'
	id = Column(Integer, primary_key = True)
	title = Column(String(200), nullable = False)
	content = Column(String(10), nullable=False)
	create_at = Column(DateTime)
	is_valid = Column(Boolean)


#News.metadata.create_all(engine)