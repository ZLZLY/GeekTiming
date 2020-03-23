from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column,Integer, String, DateTime, Boolean
from sqlalchemy.orm import sessionmaker
#('mysql://用户:密码@地址:端口/库名')
engine = create_engine('mysql://root:@localhost:3306/news?charset=utf8')
Base = declarative_base()
#add session
Session = sessionmaker(bind=engine)

class New(Base):
	__tablename__ = 'news'
	id = Column(Integer, primary_key = True)
	title = Column(String(200), nullable = False)
	content = Column(String(10), nullable=False)
	create_at = Column(DateTime)
	is_valid = Column(Boolean)

#News.metadata.create_all(engine)
#add data
class OrmTest(object):
	"""docstring for OrmTest"""
	def __init__(self, arg):
		super(OrmTest, self).__init__()
		self.session = Session()

	def add_one(self):

		new_obj = News(
			title = '标题'，
			content = '内容'
			type = '百家')
		self.session.add(new_obj)
		self.session.commit()
		return new_obj
#session.add_all([])

#select data->fetch
	def get_one(self):
		return self.session.query(News).get(1)
	def get_more(self):
		return self.session.query(News).filter_by(is_valid=1)

	def update_data(self):
		obj =self.session.query(News).get(38)
		obj.is_valid = 0
		self.session.add(obj)
		self.session.commit()
		return obj

	def delete_data(self):
		data = self.session.query(News).get(39)
		self.session.delete(data)
		self.session.commit()