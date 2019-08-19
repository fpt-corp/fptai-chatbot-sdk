import setuptools

with open("README.md", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name="fptai-dme-sdk-tuantk",
    version="0.0.1",
    author="Trinh Kim Tuan",
    author_email="tuantk2@fpt.com.vn",
    description="DME SDK",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/pypa/fptai_dme",
    packages=setuptools.find_packages(),
    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
)