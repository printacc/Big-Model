from sqlalchemy import Column, String, Boolean, Integer

from src.db.dao import Base, engine, get_session


# class Document(Base):
#     __tablename__ = ''
#     id = Column(Integer, primary_key=True)
#     hash_id = Column(String(30), nullable=False, unique=True)
#     content = Column(String(200), nullable=False)
#     embedding_state = Column(Boolean, default=False)


class TieBa(Base):
    __tablename__ = "tie_ba"
    id = Column(Integer, primary_key=True)
    hash_id = Column(String(30), nullable=False, unique=True)
    content = Column(String(200), nullable=False)
    embedding_state = Column(Boolean, default=False)
    tid = Column(String(20), nullable=False)

    def __repr__(self):
        return f'{self.hash_id} self.{self.content}'


